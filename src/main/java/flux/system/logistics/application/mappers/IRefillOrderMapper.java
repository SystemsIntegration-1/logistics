package flux.system.logistics.application.mappers;

import flux.system.logistics.application.responses.RefillOrderResponse;
import flux.system.logistics.domain.entities.RefillOrder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IRefillOrderMapper {
    IRefillOrderMapper INSTANCE = Mappers.getMapper(IRefillOrderMapper.class);

    RefillOrderResponse mapEntityToRefillOrderResponse(RefillOrder refillOrder);
}
