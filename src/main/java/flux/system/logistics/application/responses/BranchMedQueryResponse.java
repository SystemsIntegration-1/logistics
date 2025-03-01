package flux.system.logistics.application.responses;

import java.util.UUID;

public record BranchMedQueryResponse (
   UUID productId,
   String name,
   String category,
   int availableQuantity
){}
