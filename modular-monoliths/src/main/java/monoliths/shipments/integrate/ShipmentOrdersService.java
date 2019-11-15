package monoliths.shipments.integrate;

import lombok.AllArgsConstructor;
import monoliths.commons.model.OrderSheet;
import monoliths.orders.domain.entity.Order;
import monoliths.orders.domain.entity.ShippingDesk;
import monoliths.shipments.domain.usecase.DeliveryProcessing;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ShipmentOrdersService implements ShippingDesk {

    private DeliveryProcessing deliveryProcessing;

    @Override
    public void register(Order order, OrderSheet orderSheet) {
        deliveryProcessing.prepareDelivery(order.getId(), orderSheet);
    }

    @Override
    public void dispatch(Order order) {
        deliveryProcessing.dispatchDelivery(order.getId());
    }

}
