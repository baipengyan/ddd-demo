package ltd.colingting.infrastructure.repository.assemble;

import ltd.colingting.domain.domain.entity.Order;
import ltd.colingting.infrastructure.persistence.po.OrderPO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author 丁浩
 * @date 2022年09月01日 14:25
 */
@Mapper
public interface OrderAssembler {

    OrderAssembler INSTANCE = Mappers.getMapper(OrderAssembler.class);

    @Mappings({
        @Mapping(target = "id.id", source = "id"),
        @Mapping(target = "address.detail", source = "addressDetail")
    })
    Order toOrder(OrderPO orderPO);
    @Mappings({
    @Mapping(target = "addressDetail", source = "address.detail"),
    @Mapping(target = "id", source = "id.id")
    })
    OrderPO fromOrder(Order aggregate);
}
