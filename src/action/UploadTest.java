package action;

import bean.SCbean.CLogin;
import bean.SCbean.CTest;
import bean.SCbean.STest;
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

/**
 * Created by sherry on 2017/3/26.
 */
public class UploadTest extends ActionSupport implements ServletRequestAware, ServletResponseAware {

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

    public UploadTest(){

        /**
         * 从客户端接收登录数据，CTest格式
         */
        Gson gson = new Gson();
        Type ctype = new com.google.gson.reflect.TypeToken<CTest>() {}.getType();
        Type stype = new com.google.gson.reflect.TypeToken<STest>() {}.getType();

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
            CLogin cTest = gson.fromJson(json, ctype);

            System.out.println("2-->" + cTest);

            STest sTest = new STest("uploadTest success");

            String result = gson.toJson(sTest, stype);
            System.out.println("3-->" + result);
            response.getWriter().write(result);

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
