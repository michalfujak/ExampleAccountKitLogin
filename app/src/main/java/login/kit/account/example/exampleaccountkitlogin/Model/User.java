package login.kit.account.example.exampleaccountkitlogin.Model;

public class User {
    // Class User
    private String name;
    private String email;
    private String created_at;
    private String updated_at = "";

    /**
     * @param
     */
    public User() {
        // Construct
    }

    /**
     *
     * @param name
     * @param email
     * @param created_at
     * @param updated_at
     */
    public User(String name, String email, String created_at, String updated_at) {
        this.name = name;
        this.email = email;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
