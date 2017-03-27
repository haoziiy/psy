package bean;


import bean.SCbean.SLogin;
import bean.SCbean.SRegister;
import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

import bean.SCbean.*;



/**
 * Created by sherry on 17/2/19.
 */
public class MongoDB {

    //1、连接到数据库
    public MongoClient getMongo(){
        //1、连接到MongoDB数据库
        MongoClient mongo=new MongoClient("localhost",27017);
        return mongo;
    }

    //2、获取指定数据库
    public DB getDb(String DbName){
        MongoClient mongo=getMongo();
        return mongo.getDB(DbName);
    }

    //3、显示数据库中所有数据库
    public void showDb(){
        MongoClient mongo=getMongo();
        //显示所有数据库
        List<String> dbs=mongo.getDatabaseNames();
        for(String database:dbs){
            System.out.println(database);
        }

    }

    //4、获取一个表
    public DBCollection getTable(DB db,String tableName){
        //如果表不存在，MongoDB将会创建一个
        DBCollection table = db.getCollection(tableName);
        return table;
    }

    //5、显示数据库中所有表
    public void showTables(DB db){
        //显示选择的数据库中所有表
        Set<String> tables=db.getCollectionNames();
        for(String coll:tables){
            System.out.println(coll);
        }
    }

    //查找并返回_id
    public ObjectId searchID(BasicDBObject basicDBObject,
                               DBCollection table){

        DBCursor dbCursor=table.find(basicDBObject);
        while(dbCursor.hasNext()) {
            ObjectId _id = (ObjectId) dbCursor.next().get("_id");

            return _id;
        }
        return null;
    }




    /**
     * 根据姓名密码，查找并返回sLogin(登录成功的返回值).
     *
     * ps:Date转换尚未测试通过.
     * update by sherry 2017-03-03
     * @param cond
     * @param table
     * @return sLogin
     */
    public SLogin checkLogin(BasicDBObject cond,
                             DBCollection table){

        DBCursor dbCursor =table.find(cond);

        SLogin sLogin = new SLogin();
        sLogin.result = "fail";
        while(dbCursor.hasNext()) {

            BasicDBObject bdbObj = (BasicDBObject) dbCursor.next();

            String id = bdbObj.get("_id").toString();
            sLogin.id = id;
            System.out.println("sLogin + _id : " + id);

            String institution = bdbObj.get("institution").toString();
            sLogin.institution = institution;
            System.out.println("sLogin + institution : " + institution);

            sLogin.result = "success";

//            Date enrollmentDate = (Date) bdbObj.get("enrollmentDate");
//            sLogin.enrollmentDate = enrollmentDate;
//            System.out.println("sLogin + enrollmentDate : " + enrollmentDate);
            return sLogin;
        }
        return null;
    }

    /**
     * 注册新用户到数据库,成功后返回注册结果
     *
     * ps:Date存储尚未测试通过
     * update by sherry 2017-02-22
     * @param obj
     * @param table
     * @return sRegister
     */
    public SRegister register(BasicDBObject obj,
                              DBCollection table){

        table.insert(obj);
       // return true;
        DBCursor dbCursor=table.find(obj);
        SRegister sRegister = new SRegister();
        sRegister.result = "fail";
        while(dbCursor.hasNext()) {
            BasicDBObject bdbObj = (BasicDBObject) dbCursor.next();
            sRegister.id = bdbObj.get("_id").toString();
            sRegister.result = "success";
            System.out.println(sRegister);
            return sRegister;
        }
        return null;
    }

    //MongoDB保存文件
    public boolean uploadFileToGridFS(DB db,String fileName,InputStream in) throws IOException {

        GridFSBucket bucket = GridFSBuckets.create((MongoDatabase) db);
        ObjectId fileId = bucket.uploadFromStream(fileName, in);
        if (fileId.toHexString() != null)
            return true;
        else return false;
    }
}
