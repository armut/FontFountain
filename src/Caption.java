import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Caption extends JPanel {
    private static ImageIcon imgClose = new ImageIcon("res/close.png");
    private static ImageIcon imgCloseOver = new ImageIcon("res/close-over.png");
    private static ImageIcon imgMin = new ImageIcon("res/min.png");
    private static ImageIcon imgMinOver = new ImageIcon("res/min-over.png");

    public Caption(JFrame frame, Color bgColor, String title) {
        setBackground(bgColor);
        setLayout(new BorderLayout());

        JPanel jpnlControl = new JPanel();
        jpnlControl.setPreferredSize(new Dimension(50, 25));
        jpnlControl.setOpaque(false);

        /* Close button */
        JButton jbClose = new JButton(imgClose);
        jbClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbClose.setOpaque(false);
        jbClose.setFocusPainted(false);
        jbClose.setBorderPainted(false);
        jbClose.setContentAreaFilled(false);
        jbClose.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jbClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        jbClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                jbClose.setIcon(imgCloseOver);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                jbClose.setIcon(imgClose);
            }
        });
        jpnlControl.add(jbClose);
        /* Close button */

        /* Minimize button */
        JButton jbMin = new JButton(imgMin);
        jbMin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jbMin.setOpaque(false);
        jbMin.setFocusPainted(false);
        jbMin.setBorderPainted(false);
        jbMin.setContentAreaFilled(false);
        jbMin.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jbMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                frame.setExtendedState(Frame.ICONIFIED);
            }
        });
        jbMin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent mouseEvent) {
                jbMin.setIcon(imgMinOver);
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {
                jbMin.setIcon(imgMin);
            }
        });
        jpnlControl.add(jbMin);
        /* Minimize button */

        add(jpnlControl, BorderLayout.LINE_START);

        JPanel jpnlTitle = new JPanel();
        jpnlTitle.setOpaque(false);
        JLabel jlblTitle = new JLabel(title);
        jpnlTitle.add(jlblTitle);
        add(jpnlTitle, BorderLayout.CENTER);
    }
}
