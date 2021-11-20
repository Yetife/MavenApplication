package africa.semicolon.ewaApp.data.models;

import lombok.Data;

@Data
public class Customer {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
