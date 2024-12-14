import java.util.HashMap;
import java.util.Map;

public class MemoryRegion {
    private final String name;
    private final long startAddress;
    private final long endAddress;
    private final boolean isReadOnly;
    private final Map<Long, Integer> memory;

    public MemoryRegion(String name, long startAddress, long endAddress, boolean isReadOnly) {
        this.name = name;
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.isReadOnly = isReadOnly;
        this.memory = new HashMap<>();
    }

    public boolean containsAddress(long address) {
        return address >= startAddress && address <= endAddress;
    }

    public boolean isReadOnly() {
        return isReadOnly;
    }

    public Integer read(long address) {
        return memory.getOrDefault(address, 0);
    }

    public boolean write(long address, int value) {
        if (isReadOnly) return false;
        if (value < 0 || value > 255) return false;
        memory.put(address, value);
        return true;
    }
}