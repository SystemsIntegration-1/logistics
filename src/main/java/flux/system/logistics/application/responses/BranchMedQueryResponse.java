package flux.system.logistics.application.responses;

import java.util.Date;
import java.util.UUID;

public record BranchMedQueryResponse (
   UUID id,
   UUID productId,
   int stock,
   Date entryDate,
   Date expirationDate
){}
