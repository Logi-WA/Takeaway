package is.vinnsla;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CustomerTest {
    @Test
    public void testCustomer() {
        Customer c1 = new Customer("John", "123 Main Street");
        assertEquals("John", c1.getName());
        assertEquals("123 Main Street", c1.getAddress());
    }
}

