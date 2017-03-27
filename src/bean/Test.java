package bean;
import java.util.List;

/**
 * Created by sherry on 2017/3/26.
 */
public class Test {

    String test_id; //本套测试的id

    String uploader_id;//上传者id

    private List<Quz> test;//这套测试包含的（多个）题目

    public Test(){}

    public Test(List<Quz> test) {
        this.test_id = test_id;
        this.test = test;
    }

    public List<Quz> getTest() {
        return test;
    }

    public void setTest(List<Quz> test) {
        this.test_id = test_id;
        this.test = test;
    }


}
