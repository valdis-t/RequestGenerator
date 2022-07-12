package gui.component.content;

import boot.GUIComponentsParameter;
import gui.component.control.ButtonForControlPanel;

public class ButtonForScriptPanel extends ButtonForControlPanel {
    public ButtonForScriptPanel(String text) {
        super(text);
        setPreferredSize(GUIComponentsParameter.getScriptButtonDimension());
    }
}
