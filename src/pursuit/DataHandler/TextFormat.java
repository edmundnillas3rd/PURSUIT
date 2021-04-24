
package pursuit.DataHandler;

public class TextFormat {
    public static String formatInsertedTableName(String tblName) {
        String formattedName = tblName;
        char ch = '_';
        formattedName = formattedName.replace(' ', ch);
        return formattedName;
    }
    
    public static String formatRetrievedTableName(String tblName) {
        String formattedName = tblName;
        char ch = ' ';
        formattedName = formattedName.replace('_', ch);
        return formattedName;
    }
}
