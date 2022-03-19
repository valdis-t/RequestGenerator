package component.content;

import boot.GUIComponentsParameter;

import javax.swing.*;

public class CheckBoxForContentPanel extends JCheckBox {
    public CheckBoxForContentPanel(String text) {
        super(text);
        setFont(GUIComponentsParameter.getContentPanelFont());
        setBackground(GUIComponentsParameter.contentPanelBackgroundColor);
    }
}
