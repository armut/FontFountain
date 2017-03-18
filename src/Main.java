import fenestra.*;
import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Where the story begins.");
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Fenestra f = new Fenestra(Palette.deepTaupe, Palette.paynesGrey,
                        Palette.middleRedPurple, "FontFountain", 500, 300);
                Floris ff = new Floris(f, Palette.deepTaupe, Palette.paynesGrey,
                        Palette.mistyRose, "Font Viewer", 300, 450);
            }
        });
        //TODO:The main program will inherit Fenestra Floris.
    }
}
