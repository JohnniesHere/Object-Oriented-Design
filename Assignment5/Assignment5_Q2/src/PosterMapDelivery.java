import java.util.ArrayList;
import java.util.List;

public class PosterMapDelivery extends BaseProduct implements PhysicalDeliverable {
    public PosterMapDelivery(String title, Integer userID) {
        super(title, userID);
    }

    @Override
    public List<Location> getDeliveryLocations() {
        return getHighStreetLocations();
    }

    private List<Location> getHighStreetLocations() {
        List<Location> locations = new ArrayList<>();
        locations.add(new Location("Central Store", "123 Main St", LocationType.HIGH_STREET_SHOP));
        locations.add(new Location("Premium Store", "321 High St", LocationType.HIGH_STREET_SHOP));
        return locations;
    }
}