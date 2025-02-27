package flux.system.logistics.application.mappers;

import flux.system.logistics.application.dto.response.RefillResponse;
import flux.system.logistics.domain.entities.Refill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IRefillMapper {
    IRefillMapper INSTANCE = Mappers.getMapper(IRefillMapper.class);

    @Mapping(source = "refillId", target = "refill_id")
    RefillResponse mapRefilltoRefillResponse(Refill refill);

}
