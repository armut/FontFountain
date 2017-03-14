import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Where the story begins.");
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Fenestra f = new Fenestra();
                f.setVisible(true);
            }
        });
    }
}
