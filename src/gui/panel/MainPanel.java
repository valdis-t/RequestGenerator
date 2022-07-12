package gui.panel;

import boot.GUIComponentsParameter;
import gui.component.content.TextAreaForContentPanel;
import gui.component.content.TextFieldForContentPanel;
import gui.layout.VerticalLayoutManager;
import util.text.StringDefaultValue;
import util.text.TextBuilder;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public abstract class MainPanel extends JPanel implements Readable, Comparable<MainPanel> {

    protected final TextBuilder textBuilder = new TextBuilder();
    private final List<JTextField> textFields = new LinkedList<>();
    private final List<JTextArea> textAreas = new LinkedList<>();
    protected String panelName;
    protected String nameForAnalyticKey;

    protected MainPanel(Dimension dimension) {
        setSize(dimension.width, dimension.height);
        setFont(GUIComponentsParameter.getContentPanelFont());
        setBackground(GUIComponentsParameter.contentPanelBackgroundColor);
        setLayout(new VerticalLayoutManager(dimension.width, dimension.height));
    }

    protected MainPanel(String panelName) {
        this(GUIComponentsParameter.getRequestPanelDimension());
        this.panelName = panelName;
        setName(panelName);
    }

    public String getPanelName() {
        return panelName;
    }

    public String getNameForAnalyticKey() {
        return nameForAnalyticKey;
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

    @Override
    public int compareTo(MainPanel o) {
        return o.getName().compareTo(getName());
    }

    public JTextField getTextField() {
        return new TextFieldForContentPanel(GUIComponentsParameter.getTextFieldDimension());
    }

    public JTextArea getTextArea() {
        return new TextAreaForContentPanel();
    }

    public abstract String getAllText();
}
