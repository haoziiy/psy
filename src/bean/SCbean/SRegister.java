package bean.SCbean;

/**
 * 注册时，服务器返回信息
 * Created by sherry on 17/2/20.
 */
public class SRegister {
    public String id;
    public String result;

    public SRegister(){
        super();
    }
    public SRegister(String id, String result) {
        this.id = id;
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "SRegister{" +
                "id='" + id + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
