package bean.SCbean;

import java.util.Date;

/**
 * 登录时，服务器返回信息
 * Created by sherry on 17/2/22.
 */
public class SLogin {
    public String id;
    public String result;
    public String institution;
    Date enrollmentDate;

    public SLogin(){
        super();
    }

    public SLogin(String id, String result,String institution,Date enrollmentDate) {
        this.id = id;
        this.result = result;
        this.institution = institution;
        this.enrollmentDate = enrollmentDate;
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

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    @Override
    public String toString() {
        return "SLogin{" +
                "id='" + id + '\'' +
                ", result='" + result + '\'' +
                ", institution='" + institution + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}
