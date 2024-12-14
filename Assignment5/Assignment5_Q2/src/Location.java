public class Location {
    private String address;
    private String name;
    private LocationType type;

    public Location(String name, String address, LocationType type) {
        this.name = name;
        this.address = address;
        this.type = type;
    }

    public String getAddress() { return address; }
    public String getName() { return name; }
    public LocationType getType() { return type; }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(LocationType type) {
        this.type = type;
    }
}