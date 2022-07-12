package gui.component.content;

import boot.GUIComponentsParameter;

import javax.swing.*;
import java.awt.*;

public class ButtonForContentPanel extends JButton {
    public ButtonForContentPanel(String text) {
        super(text);
        setMargin(new Insets(2, 0, 2, 0));
        setBackground(GUIComponentsParameter.buttonColor);
        setPreferredSize(GUIComponentsParameter.getContentButtonDimension());
        setFont(GUIComponentsParameter.getContentPanelFont());
    }
}
