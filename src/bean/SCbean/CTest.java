package bean.SCbean;
import bean.*;

/**
 * Created by sherry on 2017/3/26.
 */
public class CTest {
    public String uploader_id;
    Test test;

    public CTest(String uploader_id, Test test){
        this.uploader_id = uploader_id;
        this.test = test;
    }

    public String getUploader_id() {
        return uploader_id;
    }

    public void setUploader_id(String uploader_id) {
        this.uploader_id = uploader_id;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "CTest{" +
                "uploader_id='" + uploader_id + '\'' +
                ", test=" + test +
                '}';
    }
}

