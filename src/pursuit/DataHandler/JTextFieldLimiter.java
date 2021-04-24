
package pursuit.DataHandler;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimiter extends PlainDocument {
    private int limit;
    
    public JTextFieldLimiter(int limit) {
        this.limit = limit;
    }
    
    @Override
    public void insertString(int offset, String str, AttributeSet set) throws BadLocationException {
        if (str == null) {
            return;
        } else if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, set);
        }
    }
}
