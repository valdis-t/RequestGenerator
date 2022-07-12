package gui.component.content;

import boot.GUIComponentsParameter;

import javax.swing.*;

public class VerticalPanelForContentPanel extends JPanel {
    public VerticalPanelForContentPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(GUIComponentsParameter.contentPanelBackgroundColor);
    }
}
