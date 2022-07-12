package gui.panel.requestgenerator.entities;

import gui.component.content.ComboBoxForContentPanel;
import gui.component.content.LabelForContentPanel;
import gui.panel.requestgenerator.RequestPanel;
import util.text.StringDefaultValue;

import javax.swing.*;
import java.util.Vector;

public class VerificationPanel extends RequestPanel {
    private final JTextArea requestField;
    private final JComboBox<String> requestTypesChoice;
    private final String REQUEST_TYPE_TEXT;
    private final String REQUEST_LABEL_TEXT;

    {
        requestField = getTextArea();
        REQUEST_TYPE_TEXT = "Тип звернення";
        REQUEST_LABEL_TEXT = "Запит верифікаторам:";
        Vector<String> requestTypes = new Vector<>();
        requestTypes.add("нові документи");
        requestTypes.add("заявка на утриманні");
        requestTypes.add("запит на повторну реєстрацію через Дія");
        requestTypes.add("видалення дублю");
        requestTypesChoice = new ComboBoxForContentPanel<>(requestTypes);
        nameForAnalyticKey = (String) requestTypesChoice.getSelectedItem();
        requestTypesChoice.addActionListener(l -> {
            nameForAnalyticKey = (String) requestTypesChoice.getSelectedItem();
        });
    }

    public VerificationPanel() {
        super("Верифікатори");
        add(new LabelForContentPanel(REQUEST_TYPE_TEXT));
        add(requestTypesChoice);
        add(new LabelForContentPanel(REQUEST_LABEL_TEXT));
        add(requestField);
    }

    @Override
    public String getAllText() {
        textBuilder
                .append(nameField.getText())
                .append(idField.getText())
                .append(phoneNumberField.getText())
                .append((String) requestTypesChoice.getSelectedItem())
                .append(StringDefaultValue.NEW_LINE_TEXT)
                .append(requestField.getText());
        return textBuilder.toString();
    }
}
