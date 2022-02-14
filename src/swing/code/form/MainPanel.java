package swing.code.form;

import javax.swing.*;

public abstract class MainPanel extends JPanel implements Readable{
    protected static final String EMPTY = "";
    protected static final String WRONG_REQUEST = "Некорректный запрос!";
    protected static final String NEW_LINE = "\n";

    public abstract String getAllText();
    public abstract void cleanAllFields();
}
