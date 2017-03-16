import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fenestra extends JFrame {

    // Class attributes:
    private final static int WIDTH = 500;
    private final static int HEIGHT = 400;
    private final static String title = "Font Fountain";
    private int innerPosX, innerPosY;
    private Palette palette = Palette.getPalette();
    static int ptr = 0;


    public Fenestra() {
        setFrame(palette.mistyRose);
    }

    private void setFrame(Color bgColor) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle(title);
        setSize(WIDTH, HEIGHT);
        setResizable(true);
        setUndecorated(true);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(bgColor);
        add(new Caption(palette.middleRedPurple), BorderLayout.PAGE_START);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                innerPosX = mouseEvent.getX();
                innerPosY = mouseEvent.getY();

                if(mouseEvent.isPopupTrigger()) {
                    JPopupMenu contextMenu = new JPopupMenu();
                    JMenuItem miUp = new JMenuItem("Renk değiştir \uD83E\uDC69.");
                    JMenuItem miDown = new JMenuItem("Renk değiştir \uD83E\uDC6B.");
                    miDown.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            getContentPane().setBackground(palette.getColors()[ptr]);
                            System.out.println(ptr);
                            ptr = ptr == palette.getColorLength() - 1 ? 0 : ptr + 1;
                        }
                    });
                    miUp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            getContentPane().setBackground(palette.getColors()[ptr]);
                            System.out.println(ptr);
                            ptr = ptr == 0 ? palette.getColorLength() - 1 : ptr - 1;
                        }
                    });
                    contextMenu.add(miUp);
                    contextMenu.add(miDown);
                    contextMenu.show(mouseEvent.getComponent(), mouseEvent.getX(), mouseEvent.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                // do something...
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                setLocation(mouseEvent.getXOnScreen() - innerPosX,
                        mouseEvent.getYOnScreen() - innerPosY);
            }
        });
    }

}
