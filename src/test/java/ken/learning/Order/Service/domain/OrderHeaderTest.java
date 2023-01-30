package ken.learning.Order.Service.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

//@ActiveProfiles("local")
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderHeaderTest {

    @Test
    void testEquals() {
        OrderHeader orderHeader1 = new OrderHeader();
        orderHeader1.setId(1L);

        OrderHeader orderHeader2 = new OrderHeader();
        orderHeader2.setId(1L);

        assert orderHeader1.equals(orderHeader2);
    }

    @Test
    void testNotEquals() {
        OrderHeader orderHeader1 = new OrderHeader();
        orderHeader1.setId(1L);

        OrderHeader orderHeader2 = new OrderHeader();
        orderHeader2.setId(3L);

        assertFalse(orderHeader1.equals(orderHeader2));
    }

}