package selector;

import fenestra.Palette;
import menu.FontSelectorMenu;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.PatternSyntaxException;

public class FontSelector {
    private JPanel jpnlFontSelector;
    private JTable fontsTable;
    private FontTableModel tableModel;
    private ListSelectionModel listSelectionModel;
    private final ArrayList<Font> fontsList;
    private FontListHandler handler;
    private JTextField searchField;

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

        // Add the sub-panels to the loom panel to show them up.
        jpnlLoom.add(initSearchfield(), BorderLayout.PAGE_START);
        jpnlLoom.add(scrollPane, BorderLayout.CENTER);

        jpnlFontSelector.add(new FontSelectorMenu(), BorderLayout.PAGE_START);
        jpnlFontSelector.add(jpnlLoom, BorderLayout.CENTER);

        loadSystemFonts();
    }

    private JPanel initSearchfield() {
        // Initialize a sorter for filtering operations.
        TableRowSorter<FontTableModel> sorter = new TableRowSorter<>((FontTableModel)fontsTable.getModel());
        // Set this sorter as fontsTable's row sorter.
        fontsTable.setRowSorter(sorter);

        // Initialize a panel for text field.
        JPanel jpnlSearch = new JPanel(new BorderLayout());
        jpnlSearch.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(
                Palette.darkGunmetal, 3), "Search" ));
        jpnlSearch.setBackground(Palette.deepTaupe);

        // Instantiate the searchField text field and add listeners.
        searchField = new JTextField();
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent documentEvent) {
                RowFilter<FontTableModel, Object> rf = null;
                try {
                    rf = RowFilter.regexFilter(searchField.getText(), 0);
                } catch(PatternSyntaxException e) {
                    return;
                }
                sorter.setRowFilter(rf);
            }

            @Override
            public void removeUpdate(DocumentEvent documentEvent) {
                RowFilter<FontTableModel, Object> rf = null;
                try {
                    rf = RowFilter.regexFilter(searchField.getText(), 0);
                } catch(PatternSyntaxException e) {
                    return;
                }
                sorter.setRowFilter(rf);
            }

            @Override
            public void changedUpdate(DocumentEvent documentEvent) {

            }
        });

        // Add search field to the panel.
        jpnlSearch.add(searchField);
        return jpnlSearch;
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
