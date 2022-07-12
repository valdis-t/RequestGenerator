package gui.component.content;

import boot.GUIComponentsParameter;

import javax.swing.*;

public class HorizontalPanelForContentPanel extends JPanel {
    public HorizontalPanelForContentPanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(GUIComponentsParameter.contentPanelBackgroundColor);
    }
}
