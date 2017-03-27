package action;

import bean.SCbean.CLogin;
import bean.SCbean.SLogin;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.*;
import java.util.Calendar;
import bean.*;


/**
 * Created by zhangyu on 15/02/2017.
 */
public class Login extends ActionSupport implements ServletRequestAware, ServletResponseAware {


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

    public void Login() {

        /**
         * 从客户端接收登录数据，CLogin格式
         */
         Gson gson = new Gson();
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
            CLogin cLogin = gson.fromJson(json, ctype);

            System.out.println("2-->" + cLogin);


            SLogin sLogin = new SLogin("success", "asdfasdf32423", "teacher", Calendar.getInstance().getTime());

           // SLogin sLogin = checkLogin(cLogin);

            String result = gson.toJson(sLogin, stype);
            System.out.println("3-->" + result);
            response.getWriter().write(result);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 登录检查+数据库+返回SLogin
     */
    private SLogin checkLogin(CLogin cLogin)
    {
        SLogin sLogin = null;

        MongoDB mongo = new MongoDB();
        mongo.getMongo();
        DB userdb = mongo.getDb("user");
        DBCollection userTable = mongo.getTable(userdb, "user");

        BasicDBObject cond = new BasicDBObject();
        cond.put("name", cLogin.getName());
        cond.put("password", cLogin.getPassword());

        sLogin = mongo.checkLogin(cond,userTable);
        if (sLogin == null){
            System.out.println("sLogin数据为空");
            return null;

        }
        else {
            return sLogin;
        }

    }
}
