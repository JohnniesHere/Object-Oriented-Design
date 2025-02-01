import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameUI {
    private static final Random RANDOM = new Random();
    private static final ButtonFactory factory = ButtonFactory.getInstance();
    
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        
        // Update button locations every 2 seconds
        executor.scheduleAtFixedRate(() -> {
            for (Button.Color color : Button.Color.values()) {
                Button button = factory.getButton(color);
                updateButtonLocation(button);
                button.display();
            }
        }, 0, 2, TimeUnit.SECONDS);
    }
    
    private static void updateButtonLocation(Button button) {
        button.setLocation(
            RANDOM.nextInt(100),
            RANDOM.nextInt(100)
        );
    }
}