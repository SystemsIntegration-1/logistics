package flux.logistic.application.mappers;

import flux.logistic.application.dto.request.BranchRefillRequest;
import flux.logistic.application.dto.response.RefillResponse;
import flux.logistic.domain.entities.Refill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IRefillMapper {
    IMedMapper INSTANCE = Mappers.getMapper(IMedMapper.class);

    @Mapping(target = "refillId", ignore = true)
    Refill branchRequestToRefill(BranchRefillRequest refillRequest);
    RefillResponse mapRefilltoRefillResponse(Refill refill);

}
