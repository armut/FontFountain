package selector;

import menu.FontSelectorMenu;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class FontSelector {
    private JPanel jpnlFontSelector;
    private JTable fontsTable;
    private FontTableModel tableModel;
    private ListSelectionModel listSelectionModel;
    private final ArrayList<Font> fontsList;
    private FontListHandler handler;

    public FontSelector(Color bgColor, int width, int height) {
        fontsList = new ArrayList<>();

        jpnlFontSelector = new JPanel();
        jpnlFontSelector.setPreferredSize(new Dimension(width, height));
        jpnlFontSelector.setLayout(new BorderLayout());
        jpnlFontSelector.setBackground(bgColor);

        // Placing a filler JPanel to distinguish menu and the other content.
        JPanel jpnlLoom = new JPanel(new BorderLayout());

        // Initialize and setup tableModel.
        tableModel = new FontTableModel();
        tableModel.addColumn("Font Names");
        tableModel.addColumn("Fonts");

        // Initialize and setup fontsTable.
        fontsTable = new JTable(tableModel);
        fontsTable.setFillsViewportHeight(true);
        fontsTable.setShowGrid(false);
        fontsTable.setTableHeader(null);
        // Well...Why do we need to get rid of the second column?
        // The answer is, we are using second column as real Font instances
        // list and the first one for just their names. When user clicks first
        // column we are redirecting the input to the second column which
        // is invisible to the user and holds real font objects.
        fontsTable.getColumnModel().getColumn(1).setMaxWidth(0);
        fontsTable.getColumnModel().getColumn(1).setMinWidth(0);
        fontsTable.getColumnModel().getColumn(1).setPreferredWidth(0);

        // Initialize the handler with parameters needed.
        handler = new FontListHandler(fontsTable, tableModel);

        // Initialize listSelectionModel and set our JTable's
        // selection model to our listSelectionModel.
        listSelectionModel = fontsTable.getSelectionModel();
        listSelectionModel.addListSelectionListener(handler);
        fontsTable.setSelectionModel(listSelectionModel);

        // Initialize a JScrollPane with our JTable in it.
        JScrollPane scrollPane = new JScrollPane(fontsTable);

        // Add the scrollPane to the panel to show it up.
        jpnlLoom.add(scrollPane, BorderLayout.CENTER);

        jpnlFontSelector.add(new FontSelectorMenu(), BorderLayout.PAGE_START);
        jpnlFontSelector.add(jpnlLoom, BorderLayout.CENTER);

        loadSystemFonts();
    }

    public JPanel getPanel() {
        return jpnlFontSelector;
    }

    public FontListHandler getHandler() {
        return handler;
    }

    private void loadSystemFonts() {
        Font[] systemFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
        Collections.addAll(fontsList, systemFonts);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                for(Font f : systemFonts) {
                    // First column for font names.
                    // Second column for real font objects.
                    tableModel.addRow(f.getFontName(), f);
                }
                System.out.println("System fonts are loaded.");
            }
        });
    }
}
