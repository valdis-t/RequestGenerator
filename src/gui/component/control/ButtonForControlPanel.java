package gui.component.control;

import boot.GUIComponentsParameter;

import javax.swing.*;
import java.awt.*;

public class ButtonForControlPanel extends JButton {
    public ButtonForControlPanel(String text) {
        super(text);
        setMargin(new Insets(2, 0, 2, 0));
        setBackground(GUIComponentsParameter.buttonColor);
        setPreferredSize(GUIComponentsParameter.getControlButtonDimension());
        setFont(GUIComponentsParameter.getButtonForControlPanelFont());
    }
}
