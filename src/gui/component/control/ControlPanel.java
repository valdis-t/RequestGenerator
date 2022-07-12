package gui.component.control;

import boot.GUIComponentsParameter;

import javax.swing.*;

public class ControlPanel extends JPanel {
    public ControlPanel() {
        super();
        setPreferredSize(GUIComponentsParameter.getControlPanelDimension());
        setBackground(GUIComponentsParameter.frameBackgroundColor);
    }
}
