package gui.panel.requestgenerator.entities;

import gui.component.content.ComboBoxForContentPanel;
import gui.component.content.LabelForContentPanel;
import gui.panel.requestgenerator.RequestPanel;

import javax.swing.*;
import java.util.Vector;

public class DeliveryPanel extends RequestPanel {
    private final JComboBox<String> deliveryTypeField;
    private final JTextArea commentaryField;

    private final String DELIVERY_TYPE_TEXT;

    {
        DELIVERY_TYPE_TEXT = "Тип доставки";
        Vector<String> deliveryTypes = new Vector<>();
        deliveryTypes.add("Кур'єр від банку");
        deliveryTypes.add("Нова пошта");
        deliveryTypes.add("Самовивіз");
        deliveryTypes.add("Кур'єр SmartDelivery");

        commentaryField = getTextArea();
        deliveryTypeField = new ComboBoxForContentPanel<>(deliveryTypes);
    }

    public DeliveryPanel() {
        super("Доставка");
        nameForAnalyticKey = panelName;
        add(new LabelForContentPanel(DELIVERY_TYPE_TEXT));
        add(deliveryTypeField);
        add(new LabelForContentPanel(COMMENTARY_LABEL_TEXT));
        add(commentaryField);
    }

    @Override
    public String getAllText() {
        textBuilder
                .append(nameField.getText())
                .append(idField.getText())
                .append(phoneNumberField.getText())
                .append((String) deliveryTypeField.getSelectedItem())
                .append(commentaryField.getText());
        return textBuilder.toString();
    }
}