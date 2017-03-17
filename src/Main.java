import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Where the story begins.");
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Fenestra f = new Fenestra(Palette.getPalette().deepTaupe,
                        Palette.getPalette().paynesGrey,
                        "FontFountain", 500, 300);
                f.setVisible(true);

                /*Fenestra f2 = new Fenestra(Palette.getPalette().cameoPink,
                        Palette.getPalette().paynesGrey,
                        "Font Selector", 200, 200);
                f2.setVisible(true);*/

                //TODO: Declare one of the fenestra as main and apply it exit_on_close not the others.
            }
        });
    }
}
