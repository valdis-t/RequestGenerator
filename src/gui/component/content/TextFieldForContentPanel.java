package gui.component.content;

import boot.GUIComponentsParameter;

import javax.swing.*;
import java.awt.*;

public class TextFieldForContentPanel extends JTextField {
    public TextFieldForContentPanel(Dimension dimension) {
        setPreferredSize(new Dimension(dimension));
        setFont(GUIComponentsParameter.getContentPanelFont());
    }
}
