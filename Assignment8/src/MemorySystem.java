import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.util.*;

public class MemorySystem {
    private final List<MemoryRegion> regions = new ArrayList<>();

    public void loadMemoryMap(String xmlFile) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(xmlFile));
            doc.getDocumentElement().normalize();

            NodeList regionList = doc.getElementsByTagName("Region");
            for (int i = 0; i < regionList.getLength(); i++) {
                Node regionNode = regionList.item(i);
                if (regionNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) regionNode;
                    String name = element.getElementsByTagName("Name").item(0).getTextContent();
                    long startAddress = Long.parseLong(element.getElementsByTagName("StartAddress").item(0).getTextContent().substring(2), 16);
                    long endAddress = Long.parseLong(element.getElementsByTagName("EndAddress").item(0).getTextContent().substring(2), 16);
                    boolean isReadOnly = element.getElementsByTagName("Cradentials").item(0).getTextContent().equals("ReadOnly");

                    regions.add(new MemoryRegion(name, startAddress, endAddress, isReadOnly));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void processRequests(String csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Skip header
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 2) continue;

                String operation = parts[0].trim();
                long address = Long.parseLong(parts[1].trim().substring(2), 16);

                switch (operation.toLowerCase()) {
                    case "read":
                        processRead(address);
                        break;
                    case "write":
                        if (parts.length < 3) {
                            System.out.printf("FAILED: Missing value for write operation at address 0x%08X%n", address);
                            continue;
                        }
                        int value = Integer.parseInt(parts[2].trim().substring(2), 16);
                        processWrite(address, value);
                        break;
                    default:
                        System.out.printf("FAILED: Invalid operation '%s' at address 0x%08X%n",
                                operation, address);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processRead(long address) {
        Optional<MemoryRegion> region = findRegion(address);
        if (region.isPresent()) {
            int value = region.get().read(address);
            System.out.printf("SUCCESS: Read value 0x%02X from address 0x%08X%n",
                    value, address);
        } else {
            System.out.printf("FAILED: Cannot read from invalid address 0x%08X%n",
                    address);
        }
    }

    private void processWrite(long address, int value) {
        Optional<MemoryRegion> region = findRegion(address);
        if (region.isPresent()) {
            if (region.get().write(address, value)) {
                System.out.printf("SUCCESS: Wrote value 0x%02X to address 0x%08X%n",
                        value, address);
            } else {
                System.out.printf("FAILED: Cannot write to read-only address 0x%08X or invalid value 0x%02X%n",
                        address, value);
            }
        } else {
            System.out.printf("FAILED: Cannot write to invalid address 0x%08X%n",
                    address);
        }
    }

    private Optional<MemoryRegion> findRegion(long address) {
        return regions.stream()
                .filter(region -> region.containsAddress(address))
                .findFirst();
    }

    public static void main(String[] args) {
        MemorySystem system = new MemorySystem();
        system.loadMemoryMap("MemoryMapping.xml");
        system.processRequests("Request.csv");
    }
}