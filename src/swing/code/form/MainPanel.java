package swing.code.form;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public abstract class MainPanel extends JPanel implements Readable, ComponentFactory{
    protected static final String EMPTY = "";
    protected static final String WRONG_REQUEST = "Некорректный запрос!";
    protected static final String NEW_LINE = "\n";
    private List<JTextField> textFields = new LinkedList<>();
    private List<JTextArea> textAreas = new LinkedList<>();
    protected String panelName;

    public String getPanelName(){
        return panelName;
    }

    public void cleanAllFields(){
        for(JTextField current : textFields) current.setText(EMPTY);
        for(JTextArea current : textAreas) current.setText(EMPTY);
    }

    @Override
    public Component add(Component comp) {
        if(comp instanceof JTextField) textFields.add((JTextField) comp);
        else if (comp instanceof JTextArea) textAreas.add((JTextArea) comp);
        return super.add(comp);
    }

    public abstract String getAllText();

}
