package gui.component.content;

import boot.GUIComponentsParameter;

import javax.swing.*;

public class RadioButtonForContentPanel extends JRadioButton {
    public RadioButtonForContentPanel(String text) {
        super(text);
        setFont(GUIComponentsParameter.getContentPanelFont());
        setBackground(GUIComponentsParameter.contentPanelBackgroundColor);
    }
}
