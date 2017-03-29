import fenestra.*;
import javax.swing.*;
import java.awt.*;

public class Main {
    static final int WIDTH = 400;
    static final int HEIGHT = 300;
    public static void main(String[] args) {
        System.out.println("Where the story begins.");
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                FontFountain ff = new FontFountain(Palette.deepTaupe, Palette.paynesGrey,
                        Palette.middleRedPurple, "Font Fountain", WIDTH, HEIGHT);
            }
        });
    }
}
