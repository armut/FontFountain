package selector;

import fenestra.Palette;
import main.Observer;
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

public class FontSelector implements Observer {
    private JPanel jpnlFontSelector;
    private JTable fontsTable;
    private FontTableModel tableModel;
    private TableRowSorter<FontTableModel> sorter;
    private ListSelectionModel listSelectionModel;
    private FontListHandler handler;
    private JTextField searchField;

    public FontSelector(Color bgColor, int width, int height) {
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

        // Initialize a sorter for filtering operations.
        sorter = new TableRowSorter<>((FontTableModel)fontsTable.getModel());
        // Set this sorter as fontsTable's row sorter.
        fontsTable.setRowSorter(sorter);

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

        // Instantiate a FontSelectorMenu and register this class as observer.
        FontSelectorMenu menu = new FontSelectorMenu();
        menu.registerObserver(this);

        jpnlFontSelector.add(menu, BorderLayout.PAGE_START);
        jpnlFontSelector.add(jpnlLoom, BorderLayout.CENTER);

        loadSystemFonts();
    }

    private JPanel initSearchfield() {
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
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Font[] systemFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
                // If the table is not empty, then this function must be called at least once.
                // So, this time the caller wants to refresh the table. Clear the table and populate it again.
                if(tableModel.getRowCount() > 0) {
                    tableModel.setRowCount(0);
                    System.out.println("Table is cleared.");
                }

                for(Font f : systemFonts) {
                    // First column for font names.
                    // Second column for real font objects.
                    tableModel.addRow(f.getFontName(), f);
                }
                System.out.println("System fonts are loaded.");

                ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>();
                sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
                sorter.setSortKeys(sortKeys);
                System.out.println("Fonts are sorted.");
            }
        });
    }

    @Override
    public void update(Font dummy) {

    }

    @Override
    public void update(int dummy) {
        loadSystemFonts();
    }
}
