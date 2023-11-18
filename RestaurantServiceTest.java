import org.junit.jupiter.api.Test;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

class RestaurantServiceTest {
    @Test
    void testFindRestaurantByName() {
        RestaurantService service = new RestaurantService();
        service.addRestaurant("Test Restaurant", "Test Location", LocalTime.of(8, 0), LocalTime.of(20, 0));
        assertNotNull(service.findRestaurantByName("Test Restaurant"));
        assertNull(service.findRestaurantByName("Nonexistent Restaurant"));
    }

    @Test
    void testAddRestaurant() {
        RestaurantService service = new RestaurantService();
        service.addRestaurant("Test Restaurant", "Test Location", LocalTime.of(8, 0), LocalTime.of(20, 0));
        assertEquals(1, service.getRestaurants().size());
        assertEquals("Test Restaurant", service.getRestaurants().get(0).getName());
    }

    @Test
    void testRemoveRestaurant() throws restaurantNotFoundException {
        RestaurantService service = new RestaurantService();
        service.addRestaurant("Test Restaurant", "Test Location", LocalTime.of(8, 0), LocalTime.of(20, 0));
        assertThrows(restaurantNotFoundException.class, () -> service.removeRestaurant("Nonexistent Restaurant"));
        assertDoesNotThrow(() -> service.removeRestaurant("Test Restaurant"));
    }

    @Test
    void testGetRestaurants() {
        RestaurantService service = new RestaurantService();
        service.addRestaurant("Test Restaurant", "Test Location", LocalTime.of(8, 0), LocalTime.of(20, 0));
        assertEquals(1, service.getRestaurants().size());
        assertEquals("Test Restaurant", service.getRestaurants().get(0).getName());
    }
}