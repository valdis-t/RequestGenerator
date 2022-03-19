package common.gui.panel;

import boot.GUIComponentsParameter;
import common.gui.form.StringDefaultValue;
import common.gui.layout.VerticalLayoutManager;
import component.content.TextAreaForContentPanel;
import component.content.TextFieldForContentPanel;
import util.Readable;
import util.TextBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public abstract class MainPanel extends JPanel implements Readable {

    protected final TextBuilder textBuilder = new TextBuilder();
    private final List<JTextField> textFields = new LinkedList<>();
    private final List<JTextArea> textAreas = new LinkedList<>();
    protected String panelName;

    protected MainPanel(Dimension dimension) {
        setSize(dimension.width, dimension.height);
        setFont(GUIComponentsParameter.getContentPanelFont());
        setBackground(GUIComponentsParameter.contentPanelBackgroundColor);
        setLayout(new VerticalLayoutManager(dimension.width, dimension.height));
    }

    protected MainPanel(String panelName) {
        this(GUIComponentsParameter.getRequestPanelDimension());
        this.panelName = panelName;
    }

    public String getPanelName() {
        return panelName;
    }

    @Override
    public void cleanAllFields() {
        for (JTextField current : textFields) current.setText(StringDefaultValue.EMPTY_TEXT);
        for (JTextArea current : textAreas) current.setText(StringDefaultValue.EMPTY_TEXT);
    }

    @Override
    public Component add(Component comp) {
        if (comp instanceof JTextField) textFields.add((JTextField) comp);
        else if (comp instanceof JTextArea) {
            textAreas.add((JTextArea) comp);
            return super.add(new JScrollPane(comp));
        }
        return super.add(comp);
    }

    public JTextField getTextField() {
        return new TextFieldForContentPanel();
    }

    public JTextArea getTextArea() {
        return new TextAreaForContentPanel();
    }

    public abstract String getAllText();
}
