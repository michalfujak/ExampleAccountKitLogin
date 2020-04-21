package login.kit.account.example.exampleaccountkitlogin.Model;

public class APIResponse {
    // API Response
    private boolean error;
    private String error_msg;
    private User user;
    private String uid;

    /**
     * @param
     */
    public APIResponse() {
        // Construct empty
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getError_msg() {
        return error_msg;
    }

    public void setError_msg(String error_msg) {
        this.error_msg = error_msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
