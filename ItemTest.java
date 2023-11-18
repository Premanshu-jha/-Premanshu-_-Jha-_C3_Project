import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    void testGetName() {
        Item item = new Item("Test Item", 100);
        assertEquals("Test Item", item.getName());
    }

    @Test
    void testGetPrice() {
        Item item = new Item("Test Item", 100);
        assertEquals(100, item.getPrice());
    }

    @Test
    void testToString() {
        Item item = new Item("Test Item", 100);
        assertEquals("Test Item:100\n", item.toString());
    }
}