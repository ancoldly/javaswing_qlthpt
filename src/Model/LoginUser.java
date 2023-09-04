package Model;

public class LoginUser {
    private String user;
    private String passWord;
    private String createUser;
    private String createPassWord;
    private String checkPassWord;

    public void setCheckPassWord(String checkPassWord) {
        this.checkPassWord = checkPassWord;
    }

    public String getCheckPassWord() {
        return checkPassWord;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public void setCreatePassWord(String createPassWord) {
        this.createPassWord = createPassWord;
    }

    public String getCreateUser() {
        return createUser;
    }

    public String getCreatePassWord() {
        return createPassWord;
    }

    public LoginUser() {
    }

    public LoginUser(String user, String passWord, String createUser, String createPassWord, String checkPassWord) {
        this.user = user;
        this.passWord = passWord;
        this.createUser = createUser;
        this.createPassWord = createPassWord;
        this.checkPassWord = checkPassWord;
    }

    public String getUser() {
        return user;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
