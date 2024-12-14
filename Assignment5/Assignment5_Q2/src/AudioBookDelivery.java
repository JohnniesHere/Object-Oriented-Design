import java.net.URL;

public class AudioBookDelivery extends BaseProduct implements DigitalDeliverable {
    private final URL downloadUrl;

    public AudioBookDelivery(String title, Integer userID, URL downloadUrl) {
        super(title, userID);
        this.downloadUrl = downloadUrl;
    }

    @Override
    public URL getDownloadLink() {
        return downloadUrl;
    }
}