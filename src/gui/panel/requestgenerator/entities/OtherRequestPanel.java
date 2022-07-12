package gui.panel.requestgenerator.entities;

import gui.component.content.LabelForContentPanel;
import gui.panel.requestgenerator.RequestPanel;

import javax.swing.*;

public class OtherRequestPanel extends RequestPanel {
    private final JTextArea additionalArea;
    private final JTextField descriptionForAnalyticField;

    public OtherRequestPanel() {
        super("Інші запити");
        JLabel additionalAreaLabel = new LabelForContentPanel("Додаткове текстове поле:");
        JLabel descriptionForAnalyticLabel = new LabelForContentPanel("Ключове слово");
        additionalArea = getTextArea();
        descriptionForAnalyticField = getTextField();


        add(additionalAreaLabel);
        add(additionalArea);
        add(descriptionForAnalyticLabel);
        add(descriptionForAnalyticField);
    }

    @Override
    public String getAllText() {
        nameForAnalyticKey = descriptionForAnalyticField.getText();
        textBuilder
                .append(nameField.getText())
                .append(idField.getText())
                .append(phoneNumberField.getText())
                .append(additionalArea.getText());
        return textBuilder.toString();
    }

}
