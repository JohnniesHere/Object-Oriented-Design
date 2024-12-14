import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            demonstratePhysicalDeliveries();
            demonstrateDigitalDeliveries();
            demonstratePolymorphicBehavior();
        } catch (Exception e) {
            System.err.println("Error during demonstration: " + e.getMessage());
        }
    }

    private static void demonstratePhysicalDeliveries() {
        System.out.println("\n=== Physical Delivery Demonstration ===");

        BookDelivery book = new BookDelivery("Clean Code", 1001);
        System.out.println("\nBook Delivery:");
        System.out.println("Title: " + book.getTitle());
        System.out.println("User ID: " + book.getUserID());

        List<Location> bookLocations = book.getDeliveryLocations();
        System.out.println("Available delivery locations for book:");
        printLocations(bookLocations);

        PosterMapDelivery poster = new PosterMapDelivery("World Map 2024", 1001);
        System.out.println("\nPoster Delivery:");
        System.out.println("Title: " + poster.getTitle());
        System.out.println("User ID: " + poster.getUserID());

        List<Location> posterLocations = poster.getDeliveryLocations();
        System.out.println("Available delivery locations for poster (high street only):");
        printLocations(posterLocations);
    }

    private static void demonstrateDigitalDeliveries() throws MalformedURLException {
        System.out.println("\n=== Digital Delivery Demonstration ===");

        AudioBookDelivery audioBook = new AudioBookDelivery(
                "Clean Code Audiobook",
                1001,
                new URL("http://example.com/audiobooks/cleancode")
        );

        System.out.println("\nAudiobook Delivery:");
        System.out.println("Title: " + audioBook.getTitle());
        System.out.println("User ID: " + audioBook.getUserID());
        System.out.println("Download URL: " + audioBook.getDownloadLink());
    }

    private static void demonstratePolymorphicBehavior() throws MalformedURLException {
        System.out.println("\n=== Polymorphic Behavior Demonstration ===");

        List<Deliverable> deliverables = new ArrayList<>();
        deliverables.add(new BookDelivery("Design Patterns", 1001));
        deliverables.add(new PosterMapDelivery("Europe Map", 1002));
        deliverables.add(new AudioBookDelivery("Design Patterns Audiobook", 1003,
                new URL("http://example.com/audiobooks/patterns")));

        System.out.println("\nProcessing different types of deliverables:");
        for (Deliverable item : deliverables) {
            processDeliverable(item);
        }
    }

    private static void processDeliverable(Deliverable item) {
        System.out.println("\nProcessing delivery for: " + item.getTitle());
        System.out.println("User ID: " + item.getUserID());

        if (item instanceof PhysicalDeliverable physical) {
            System.out.println("Type: Physical Delivery");
            System.out.println("Available delivery locations:");
            printLocations(physical.getDeliveryLocations());
        } else if (item instanceof DigitalDeliverable digital) {
            System.out.println("Type: Digital Delivery");
            System.out.println("Download URL: " + digital.getDownloadLink());
        }
    }

    private static void printLocations(List<Location> locations) {
        if (locations.isEmpty()) {
            System.out.println("  No locations available");
            return;
        }

        for (Location location : locations) {
            System.out.println("  - " + location.getName() +
                    " (" + location.getType() + "): " +
                    location.getAddress());
        }
    }
}