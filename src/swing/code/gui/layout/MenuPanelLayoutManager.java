package swing.code.gui.layout;

import swing.code.form.ComponentSize;

import java.awt.*;

public class MenuPanelLayoutManager extends FlowLayout {
    @Override
    public Dimension preferredLayoutSize(Container target) {
        return getSize();
    }

    @Override
    public Dimension minimumLayoutSize(Container target) {
        return getSize();
    }

    private Dimension getSize(){
        return new Dimension(ComponentSize.PANEL_WIDTH,ComponentSize.MENU_PANEL_HEIGHT);
    }
}