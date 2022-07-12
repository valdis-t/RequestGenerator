package gui.component.control;

import boot.GUIComponentsParameter;

import javax.swing.*;

public class LabelForControlPanel extends JLabel {
    public LabelForControlPanel(String text) {
        super(text);
        setFont(GUIComponentsParameter.getControlPanelFont());
    }
}
