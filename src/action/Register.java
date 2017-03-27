package action;

import bean.SCbean.SLogin;
import bean.SCbean.SRegister;
import bean.SCbean.CLogin;
import bean.SCbean.CRegister;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;

import com.mongodb.*;
import bean.*;

/**
 * Created by sherry on 17/2/19.
 */
public class Register extends ActionSupport implements ServletRequestAware, ServletResponseAware {
    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }

    private HttpServletRequest request;
    private HttpServletResponse response;

    /**
     * 注册 update by sherry on 22/02/2017.
     */
    public void Register() {

        Gson gson = new  Gson();
        Type ctype = new com.google.gson.reflect.TypeToken<CLogin>() {}.getType();
        Type stype = new com.google.gson.reflect.TypeToken<SLogin>() {}.getType();


        try {
            BufferedReader br = new BufferedReader(new
                    InputStreamReader(request.getInputStream(), "UTF-8"));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            System.out.println("1-->" + sb);
            String json = sb.toString();

            CRegister cRegister = gson.fromJson(json,ctype);
            System.out.println("2-->" + cRegister);


            // SLogin sLogin = checkLogin(cLogin);
            SRegister sRegister = register(cRegister);
            String result = gson.toJson(sRegister, stype);
            System.out.println("3-->" + result);
            response.getWriter().write(result);
        }catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 注册+数据库 update by sherry on 22/02/2017.
     */
    private SRegister register(CRegister cRegister){
        MongoDB mongo = new MongoDB();
        mongo.getMongo();
        DB userdb =mongo.getDb("user");
        DBCollection userTable = mongo.getTable(userdb,"user");

        BasicDBObject obj = new BasicDBObject();
        obj.put("name",cRegister.getName());
        obj.put("password",cRegister.getPassword());
        obj.put("identity",cRegister.getIdentity());
        obj.put("institution",cRegister.getInstitution());
        obj.put("enrollmentDate",cRegister.getEnrollmentDate());
        //返回数据库注册结果
        //result or null
        SRegister result =  mongo.register(obj,userTable);

        if (result == null)
            return null;
        else
            return result;
    }
}
