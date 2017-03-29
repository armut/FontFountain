import javax.swing.*;
import java.awt.*;

/**
 * zamma on 29.03.2017.
 */
public class FontSize extends JPanel {
    private DefaultListModel<String> listModel;
    private JList<String> jlSizes;
    private int[] sizes = {4, 6, 8, 9, 10, 11, 12, 13, 14, 16, 18, 20, 22, 24, 28, 32, 36, 40, 48, 56, 64, 72, 144};

    public FontSize(Color bgColor) {
        listModel = new DefaultListModel<>();
        jlSizes = new JList<>(listModel);

        setLayout(new BorderLayout());
        setBackground(bgColor);

        JPanel jpnlLoom = new JPanel();
        jpnlLoom.add(initList(sizes));

        add(jpnlLoom, BorderLayout.CENTER);
    }

    private JPanel initList(int[] sizes) {
        FontSizeListHandler handler = new FontSizeListHandler(jlSizes);
        jlSizes.addListSelectionListener(handler);

        for(int s : sizes)
            listModel.addElement(String.valueOf(s));
        JPanel jpnlList = new JPanel();
        JScrollPane scrollPane = new JScrollPane(jlSizes);
        jpnlList.add(scrollPane);
        return jpnlList;
    }
}
