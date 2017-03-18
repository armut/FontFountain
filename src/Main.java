import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Where the story begins.");
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Fenestra f = new Fenestra(Palette.deepTaupe, Palette.paynesGrey, "FontFountain", 500, 300);
                Floris ff = new Floris(Palette.deepTaupe, Palette.paynesGrey, "Font Viewer", 300, 450);
            }
        });
    }
}
