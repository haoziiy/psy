package bean.SCbean;

import bean.Test;

/**
 * Created by sherry on 2017/3/26.
 */
public class STest {

    String result;

    public STest(String result)
    {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "STest{" +
                "result='" + result + '\'' +
                '}';
    }
}
