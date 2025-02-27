package flux.system.logistics.application.mappers;

import flux.system.logistics.application.requests.OrderItemCreateRequest;
import flux.system.logistics.domain.entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IOrderItemMapper {

  IOrderItemMapper INSTANCE = Mappers.getMapper(IOrderItemMapper.class);

  OrderItem mapCreateRequestToEntity(OrderItemCreateRequest orderItemCreateRequest);
}
