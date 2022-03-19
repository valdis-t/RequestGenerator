package requestgenerator.gui.panel.entities;

import common.gui.form.StringDefaultValue;
import component.content.ComboBoxForContentPanel;
import component.content.LabelForContentPanel;
import requestgenerator.form.RequestPanel;

import javax.swing.*;
import java.util.Vector;

public class VerificationPanel extends RequestPanel {
    private static VerificationPanel panel;

    private final JTextArea requestField;
    private final JComboBox<String> requestTypesChoice;
    private final String REQUEST_TYPE_TEXT;
    private final String REQUEST_LABEL_TEXT;

    {
        requestField = getTextArea();
        REQUEST_TYPE_TEXT = "Тип обращения";
        REQUEST_LABEL_TEXT = "Запрос верификаторам:";
        Vector<String> requestTypes = new Vector<>();
        requestTypes.add("новые документы");
        requestTypes.add("заявка на удержании");
        requestTypes.add("запрос на повторную регистрацию через Дия");
        requestTypes.add("удаление дубля");
        requestTypesChoice = new ComboBoxForContentPanel<>(requestTypes);
    }

    private VerificationPanel() {
        super("Верификаторы");
        add(new LabelForContentPanel(REQUEST_TYPE_TEXT));
        add(requestTypesChoice);
        add(new LabelForContentPanel(REQUEST_LABEL_TEXT));
        add(requestField);
    }

    public static VerificationPanel getInstance() {
        if (panel == null) panel = new VerificationPanel();
        return panel;
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
