package requestgenerator.gui.panel.entities;

import component.content.ComboBoxForContentPanel;
import component.content.LabelForContentPanel;
import requestgenerator.form.RequestPanel;

import javax.swing.*;
import java.util.Vector;

public class DeliveryPanel extends RequestPanel {
    private static DeliveryPanel panel;

    private final JComboBox<String> deliveryTypeField;
    private final JTextArea commentaryField;

    private final String DELIVERY_TYPE_TEXT;

    {
        DELIVERY_TYPE_TEXT = "Тип доставки";
        Vector<String> deliveryTypes = new Vector<>();
        deliveryTypes.add("Курьер наш (от банка)");
        deliveryTypes.add("Новая почта");
        deliveryTypes.add("Самовывоз");
        deliveryTypes.add("Курьер SmartDelivery");

        commentaryField = getTextArea();
        deliveryTypeField = new ComboBoxForContentPanel<>(deliveryTypes);
    }

    private DeliveryPanel() {
        super("Доставка");
        add(new LabelForContentPanel(DELIVERY_TYPE_TEXT));
        add(deliveryTypeField);
        add(new LabelForContentPanel(COMMENTARY_LABEL_TEXT));
        add(commentaryField);
    }

    public static DeliveryPanel getInstance() {
        if (panel == null) panel = new DeliveryPanel();
        return panel;
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