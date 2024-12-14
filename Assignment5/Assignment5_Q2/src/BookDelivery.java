import java.util.ArrayList;
import java.util.List;

public class BookDelivery extends BaseProduct implements PhysicalDeliverable {
    public BookDelivery(String title, Integer userID) {
        super(title, userID);
    }

    @Override
    public List<Location> getDeliveryLocations() {
        return getAllDeliveryLocations();
    }

    private List<Location> getAllDeliveryLocations() {
        List<Location> locations = new ArrayList<>();
        locations.add(new Location("Central Store", "123 Main St", LocationType.HIGH_STREET_SHOP));
        locations.add(new Location("Local Pickup", "456 Oak Rd", LocationType.PICKUP_POINT));
        locations.add(new Location("Mall Store", "789 Mall Ave", LocationType.LOCAL_STORE));
        return locations;
    }
}