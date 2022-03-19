package requestgenerator.gui.panel.entities;

import component.content.LabelForContentPanel;
import requestgenerator.form.RequestPanel;

import javax.swing.*;

public class OtherRequestPanel extends RequestPanel {
    private static OtherRequestPanel panel;

    private final JTextArea additionalArea;

    private OtherRequestPanel() {
        super("Прочие");
        JLabel additionalAreaLabel = new LabelForContentPanel("Дополнительное текстовое поле:");
        additionalArea = getTextArea();

        add(additionalAreaLabel);
        add(additionalArea);
    }

    public static OtherRequestPanel getInstance() {
        if (panel == null) panel = new OtherRequestPanel();
        return panel;
    }

    @Override
    public String getAllText() {
        textBuilder
                .append(nameField.getText())
                .append(idField.getText())
                .append(phoneNumberField.getText())
                .append(additionalArea.getText());
        return textBuilder.toString();
    }

}
