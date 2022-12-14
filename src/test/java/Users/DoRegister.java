package Users;

import helpers.UserTestValues;

public class DoRegister {
    private String email;
    private String name;
    private String password;

    public DoRegister(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public DoRegister() {
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
