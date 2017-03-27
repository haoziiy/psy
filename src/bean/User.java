package bean;

/**
 * Created by sherry on 17/2/19.
 */
public class User {

    private String name;//用户名
    private String password;//密码
    private String photo;//头像

    public User(){
        super();
    }

    public User(String name,String password){
        this.name = name;
        this.password = password;
    }

    public User(String name,String password,String photo){
        this.name = name;
        this.password = password;
        this.photo = photo;
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

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
