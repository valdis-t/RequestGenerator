package component.content;

import boot.GUIComponentsParameter;

import javax.swing.*;
import java.util.Vector;

public class ComboBoxForContentPanel<E> extends JComboBox<E> {
    public ComboBoxForContentPanel(Vector<E> items) {
        super(items);
        setBackground(GUIComponentsParameter.buttonColor);
        setFont(GUIComponentsParameter.getContentPanelFont());
    }
}
