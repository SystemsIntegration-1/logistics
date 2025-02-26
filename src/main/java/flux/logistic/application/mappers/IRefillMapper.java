package flux.logistic.application.mappers;

import flux.logistic.application.dto.response.RefillResponse;
import flux.logistic.domain.entities.Refill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IRefillMapper {
    IRefillMapper INSTANCE = Mappers.getMapper(IRefillMapper.class);

    @Mapping(source = "refillId", target = "refill_id")
    RefillResponse mapRefilltoRefillResponse(Refill refill);

}
