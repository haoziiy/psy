package action;

import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangyu on 14/02/2017.
 */
public class CharCommuTest extends ActionSupport implements ServletRequestAware, ServletResponseAware {


    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request= httpServletRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        this.response = httpServletResponse;
    }

    private HttpServletRequest request;
    private HttpServletResponse response;


    public  void CharCommuTest(){
        Gson gson = new  Gson();

        Map<String, String> map = new HashMap<>();
        map.put("1","111111");
        map.put("2","222222");

        java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<Map<String,String>>() {}.getType();
        String stringMapJson = gson.toJson(map,type);
        System.out.println("json-->"+stringMapJson);

        try {
            response.setCharacterEncoding("utf-8");
//            response.setContentType("text/xml;charset=utf-8");
            this.response.getWriter().write(stringMapJson);
            // response.getOutputStream().write(null);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
