package ken.learning.Order.Service.dao;

import ken.learning.Order.Service.domain.OrderHeader;

public interface OrderHeaderDao {
    OrderHeader getOrderHeaderById(Long Id);

    OrderHeader findOrderHeaderByCustomerName(String customerName);

}
