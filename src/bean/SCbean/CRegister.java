package bean.SCbean;

import java.util.Date;

/**
 * Created by sherry on 17/2/22.
 */
public class CRegister {
    String name;
    String password;
    String identity;
    String institution;
    Date enrollmentDate;

    public CRegister(String name, String password, String identity, String institution, Date enrollmentDate){
        this.name = name;
        this.password = password;
        this.identity = identity;
        this.institution = institution;
        this.enrollmentDate = enrollmentDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
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
        return "CRegister{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", identity='" + identity + '\'' +
                ", institution='" + institution + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}
