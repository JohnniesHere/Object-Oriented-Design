public class ButtonFactory {
    private static ButtonFactory instance;
    private Button singleButton; // Changed to single button instance to enforce one-button-only requirement
    
    private ButtonFactory() {}
    
    public static ButtonFactory getInstance() {
        if (instance == null) {
            instance = new ButtonFactory();
        }
        return instance;
    }
    
    public Button getButton(Button.Color color) {
        // Only creates one button ever, ignoring subsequent color requests
        if (singleButton == null) {
            singleButton = new Button(color);
        }
        return singleButton;
    }
}
