package Domain;

public class User {

    String userId;
    String password;
    String status;
    public boolean valid;
    //String re_password;

    public User() {
    }

    public User(String userId, String password, String status, boolean valid) {
        this.userId = userId;
        this.password = password;
        this.status = status;
        this.valid = valid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void removeUserId() {
        userId = null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void removePassword() {
        password = null;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public String toString() {
        return userId;
    }
}
