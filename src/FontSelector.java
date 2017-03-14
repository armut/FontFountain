import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FontSelector extends JPanel {
    private JTextField jtfSearch;
    private DefaultListModel<String> listModel;
    private JList<String> jlFonts;
    private ArrayList<Font> fontsList;
    private JScrollPane jScrollPane;

    public FontSelector(int width, int height) {
        listModel = new DefaultListModel<>();
        jlFonts = new JList<>(listModel);
        fontsList = new ArrayList<>();
        jScrollPane = new JScrollPane(jlFonts);
        jtfSearch = new JTextField("Meraba");
        setSize(new Dimension(width, height));
        setLayout(new BorderLayout());
        appendFont(new Font("Courier", Font.PLAIN, 20));
        appendFont(new Font("Courier", Font.PLAIN, 20));
        add(jtfSearch, BorderLayout.PAGE_START);
        add(jScrollPane, BorderLayout.CENTER);

        jlFonts.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if(e.isPopupTrigger()) {
                    JPopupMenu contextMenu = new JPopupMenu();
                    JMenuItem miApply = new JMenuItem("Apply");
                    JMenuItem miJmp = new JMenuItem("Jump to dir.");
                    miApply.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            System.out.println("Apply");
                        }
                    });
                    miJmp.addActionListener((new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            System.out.println("Jmp");
                        }
                    }));
                    contextMenu.add(miApply);
                    contextMenu.add(miJmp);
                    contextMenu.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
    }

    private void appendFont(Font font) {
        fontsList.add(font);
        listModel.addElement(font.getName());
    }

    private void removeFont(int index) {
        fontsList.remove(index);
        listModel.remove(index);
    }
}
