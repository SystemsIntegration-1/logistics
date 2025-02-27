package flux.system.logistics.application.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record ContactUpdateRequest(
        @Size(max = 100, message = "Name must be less than 100 characters")
        String name,

        @Email(message = "Email must be valid")
        String email,

        @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be valid")
        String phone
) {
}
