public abstract class BaseProduct implements Deliverable {
    protected String title;
    protected Integer userID;

    public BaseProduct(String title, Integer userID) {
        this.title = title;
        this.userID = userID;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public Integer getUserID() {
        return userID;
    }
}