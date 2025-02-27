package flux.system.logistics.application.responses;

import java.util.UUID;

public record ContactResponse(
        UUID contactId,
        String name,
        String email,
        String phone
) {
}
