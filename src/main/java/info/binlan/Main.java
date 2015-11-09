package info.binlan;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import info.binlan.SudokuValidator.InvalidCell;

public class Main {
    
    private static final SudokuValidator validator = new SudokuValidator(); 
    
    public static void main(final String[] args) throws Exception {
        if (args.length != 1) {
            throw new IllegalArgumentException("Please specify the XML file name");
        }
        
        final SudokuBoard board = buildBoard(args[0]);
        final List<InvalidCell> invalidCells = validator.validate(board);
        if (invalidCells.isEmpty()) {
            System.out.println("Sudoku grid is valid");
        } else {
            System.out.println("Found following invalid numbers:");
            for (final InvalidCell cell : invalidCells) {
                final String message = String.format(
                    "Row %s Column %s Value %s", 
                    cell.getRow() + 1, 
                    cell.getColumn() + 1, 
                    cell.getValue()
                );
                System.out.println(message);
            }
        }
    }
    
    private static SudokuBoard buildBoard(final String filename) throws Exception {
        final SudokuBoard result = new SudokuBoard();
        final File xmlFile = new File(filename);
        final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder builder = factory.newDocumentBuilder();
        final Document doc = builder.parse(xmlFile);
        
        final NodeList rows = doc.getElementsByTagName("ROW");
        for (int i = 0; i < rows.getLength(); i++) {
            final Node rowNode = rows.item(i);
            if (rowNode.getNodeType() == Node.ELEMENT_NODE) {
                final Element row = (Element) rowNode;
                final NodeList columns = row.getElementsByTagName("COLUMN");
                for (int j = 0; j < columns.getLength(); j++) {
                    final Node column = columns.item(j);
                    final int value = Integer.parseInt(column.getTextContent());
                    result.set(value, i, j);
                }
            }
        }
        return result;
    }
}
