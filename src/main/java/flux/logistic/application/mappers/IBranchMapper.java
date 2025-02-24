package flux.logistic.application.mappers;

import flux.logistic.application.requests.BranchCreateRequest;
import flux.logistic.application.responses.BranchResponse;
import flux.logistic.domain.entities.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IBranchMapper {
  IBranchMapper INSTANCE = Mappers.getMapper(IBranchMapper.class);

  @Mapping(target = "branchId", ignore = true)
  Branch mapBranchCreateRequestToBranch(BranchCreateRequest branchCreateRequest);

  BranchCreateRequest mapBranchToBranchCreateRequest(Branch branch);

  Branch mapBranchResponseToBranch(BranchResponse branchResponse);

  BranchResponse mapBranchToBranchResponse(Branch branch);
}
