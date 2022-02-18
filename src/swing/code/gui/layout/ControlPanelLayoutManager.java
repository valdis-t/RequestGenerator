package swing.code.gui.layout;

import swing.code.form.ComponentSize;

import java.awt.*;

public class ControlPanelLayoutManager extends FlowLayout {
    @Override
    public Dimension preferredLayoutSize(Container target) {
        return getSize();
    }

    @Override
    public Dimension minimumLayoutSize(Container target) {
        return getSize();
    }

    private Dimension getSize(){
        return new Dimension(ComponentSize.PANEL_WIDTH,ComponentSize.CONTROL_PANEL_HEIGHT);
    }
}