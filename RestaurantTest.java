import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class RestaurantTest {
    Restaurant restaurant;
    List<Item> menu;




    @BeforeEach
    public void setup() {
        restaurant = new Restaurant("Test Restaurant", "Test Location", LocalTime.of(10, 0), LocalTime.of(22, 0));
        restaurant.addToMenu("Test Item 1", 100);
        restaurant.addToMenu("Test Item 2", 200);
        menu = restaurant.getMenu();
    }

    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time() {
        LocalTime testTime = LocalTime.of(12, 0);
        restaurant.setCurrentTime(testTime);
        assertTrue(restaurant.isRestaurantOpen());
    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time() {
        LocalTime testTime = LocalTime.of(23, 0);
        restaurant.setCurrentTime(testTime);
        assertFalse(restaurant.isRestaurantOpen());
    }

    @Test
    public void get_menu_should_return_correct_menu() {
        assertEquals(menu, restaurant.getMenu());
    }

    @Test
    public void add_to_menu_should_add_item_to_menu() {
        restaurant.addToMenu("Test Item 3", 300);
        assertEquals(3, restaurant.getMenu().size());
    }







    @Test
    public void remove_from_menu_should_remove_item_from_menu() {
        try {
            restaurant.removeFromMenu("Test Item 1");
            assertEquals(1, restaurant.getMenu().size());
        } catch (ItemNotFoundException e) {
            fail("ItemNotFoundException was thrown");
        }
    }


}