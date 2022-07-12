package gui.component.content;

import boot.GUIComponentsParameter;

import javax.swing.*;

public class TextAreaForContentPanel extends JTextArea {
    public TextAreaForContentPanel() {
        super(GUIComponentsParameter.getTextAreaRows(), GUIComponentsParameter.getTextAreaColumns());
        setFont(GUIComponentsParameter.getContentPanelFont());
        setLineWrap(true);
        setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(this);
    }
}
