package component.content;

import boot.GUIComponentsParameter;

import javax.swing.*;

public class TextFieldForContentPanel extends JTextField {
    public TextFieldForContentPanel() {
        super(GUIComponentsParameter.getTextAreaColumns());
        setFont(GUIComponentsParameter.getContentPanelFont());
    }
}
