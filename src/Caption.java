import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Caption extends JPanel {
    private static ImageIcon imgClose = new ImageIcon("res/close.png");
    private static ImageIcon imgCloseOver = new ImageIcon("res/close-over.png");
    private static ImageIcon imgMin = new ImageIcon("res/min.png");
    private static ImageIcon imgMinOver = new ImageIcon("res/min-over.png");
    private int posX, posY;

    public Caption(JFrame frame, Color bgColor, String title) {
        setBackground(bgColor);
        setLayout(new BorderLayout());
        dragWindow(frame);

        JPanel jpnlControl = new JPanel();
        jpnlControl.setPreferredSize(new Dimension(50, 25));
        jpnlControl.setOpaque(false);
        jpnlControl.add(initCloseButton(frame));
        jpnlControl.add(initMinimizeButton(frame));

        add(jpnlControl, BorderLayout.LINE_START);
        add(initCaptionTitle(title));
    }

    public Caption(JDialog frame, Color bgColor, String title) {
        setBackground(bgColor);
        setLayout(new BorderLayout());
        dragWindow(frame);

        JPanel jpnlControl = new JPanel();
        jpnlControl.setPreferredSize(new Dimension(25, 25));
        jpnlControl.setOpaque(false);
        jpnlControl.add(initCloseButton(frame));

        add(jpnlControl, BorderLayout.LINE_START);
        add(initCaptionTitle(title));
    }

    private JButton initCloseButton(Window window) {
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
                window.dispose();
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
        return jbClose;
    }

    private JButton initMinimizeButton(JFrame frame) {
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
        return jbMin;
    }

    private JPanel initCaptionTitle(String title) {
        JPanel jpnlTitle = new JPanel();
        jpnlTitle.setOpaque(false);
        JLabel jlblTitle = new JLabel(title);
        jpnlTitle.add(jlblTitle);
        return jpnlTitle;
    }

    private void dragWindow(Window window) {
        window.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                posX = mouseEvent.getX();
                posY = mouseEvent.getY();
            }
        });
        window.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                window.setLocation(mouseEvent.getXOnScreen() - posX,
                        mouseEvent.getYOnScreen() - posY);
            }
        });
    }
}
