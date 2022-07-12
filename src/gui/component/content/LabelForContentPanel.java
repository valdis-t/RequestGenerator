package gui.component.content;

import boot.GUIComponentsParameter;

import javax.swing.*;

public class LabelForContentPanel extends JLabel {
    public LabelForContentPanel(String text) {
        super(text);
        setFont(GUIComponentsParameter.getContentPanelFont());
    }
}
