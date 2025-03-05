package flux.system.logistics.application.responses;

import java.util.UUID;

// this is
public record BranchMedQueryResponse (
   UUID productId,
   int stock,
   String entryDate,
   String expirationDate
){}
