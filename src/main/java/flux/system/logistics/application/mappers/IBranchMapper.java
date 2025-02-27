package flux.system.logistics.application.mappers;

import flux.system.logistics.application.responses.BranchResponse;
import flux.system.logistics.domain.entities.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IBranchMapper {

  IBranchMapper INSTANCE = Mappers.getMapper(IBranchMapper.class);

  BranchResponse mapBranchToBranchResponse(Branch branch);
}
