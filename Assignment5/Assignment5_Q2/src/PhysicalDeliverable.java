import java.util.List;

public interface PhysicalDeliverable extends Deliverable {
    List<Location> getDeliveryLocations();
}