import java.util.HashMap;
import java.util.Map;

public class CellEmulator {
    private static Map<String, CellEmulator> emulators = new HashMap<>();
    private String cellManufacturer;

    private CellEmulator(String cellManufacturer) {
        this.cellManufacturer = cellManufacturer;
    }

    public void build() {
        System.out.println("Built!");
    }

    public static CellEmulator getInstance(String cellManufacturer) {
        if (cellManufacturer == null || cellManufacturer.trim().isEmpty()) {
            throw new IllegalArgumentException("Cell manufacturer cannot be null or empty");
        }

        String normalizedCellManufacturer = cellManufacturer.trim().toLowerCase();

        return emulators.computeIfAbsent(normalizedCellManufacturer, k -> new CellEmulator(cellManufacturer));
    }

    public String getCellManufacturer() {
        return cellManufacturer;
    }

    public static int getInstanceCount() {
        return emulators.size();
    }

    public static void main(String[] args) {
        System.out.println("Starting CellEmulator Tests...\n");

        // Test 1: Create first instance for Samsung
        System.out.println("Test 1: Creating first Samsung emulator");
        CellEmulator samsung1 = CellEmulator.getInstance("Samsung");
        System.out.println("Samsung1 manufacturer: " + samsung1.getCellManufacturer());
        samsung1.build();
        System.out.println("Current instance count: " + CellEmulator.getInstanceCount());
        System.out.println();

        // Test 2: Create instance for Xiaomi
        System.out.println("Test 2: Creating Xiaomi emulator");
        CellEmulator xiaomi = CellEmulator.getInstance("Xiaomi");
        System.out.println("Xiaomi manufacturer: " + xiaomi.getCellManufacturer());
        xiaomi.build();
        System.out.println("Current instance count: " + CellEmulator.getInstanceCount());
        System.out.println();

        // Test 3: Try to create second Samsung instance (should return existing one)
        System.out.println("Test 3: Attempting to create second Samsung emulator");
        CellEmulator samsung2 = CellEmulator.getInstance("Samsung");
        System.out.println("Samsung2 manufacturer: " + samsung2.getCellManufacturer());
        System.out.println("Are samsung1 and samsung2 the same instance? " + (samsung1 == samsung2));
        System.out.println("Current instance count: " + CellEmulator.getInstanceCount());
        System.out.println();

        // Test 4: Test case insensitivity
        System.out.println("Test 4: Testing case insensitivity");
        CellEmulator SAMSUNG = CellEmulator.getInstance("SAMSUNG");
        System.out.println("Are samsung1 and SAMSUNG the same instance? " + (samsung1 == SAMSUNG));
        System.out.println("Current instance count: " + CellEmulator.getInstanceCount());
        System.out.println();

        // Test 5: Create LG instance
        System.out.println("Test 5: Creating LG emulator");
        CellEmulator lg = CellEmulator.getInstance("LG");
        System.out.println("LG manufacturer: " + lg.getCellManufacturer());
        System.out.println("Current instance count: " + CellEmulator.getInstanceCount());
        System.out.println();

        // Test 6: Verify different instances are actually different
        System.out.println("Test 6: Verifying instance uniqueness");
        System.out.println("Are Samsung and Xiaomi different instances? " + (samsung1 != xiaomi));
        System.out.println("Are Samsung and LG different instances? " + (samsung1 != lg));
        System.out.println("Are Xiaomi and LG different instances? " + (xiaomi != lg));
        System.out.println();

        // Test 7: Test error handling (uncomment to test)
        System.out.println("Test 7: Testing error handling");
        try {
            CellEmulator nullEmulator = CellEmulator.getInstance(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Successfully caught null manufacturer: " + e.getMessage());
        }

        try {
            CellEmulator emptyEmulator = CellEmulator.getInstance("");
        } catch (IllegalArgumentException e) {
            System.out.println("Successfully caught empty manufacturer: " + e.getMessage());
        }
        System.out.println("Current instance count: " + CellEmulator.getInstanceCount());
    }
}
