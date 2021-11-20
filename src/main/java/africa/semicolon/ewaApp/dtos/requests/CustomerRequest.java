package africa.semicolon.ewaApp.dtos.requests;

import lombok.Data;

@Data
public class CustomerRequest {
    private String customerEmail;
    private String customerPassword;
    private String firstName;
    private String lastName;

}
