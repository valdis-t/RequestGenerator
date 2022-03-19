package requestgenerator.gui.panel.entities;

import component.content.ComboBoxForContentPanel;
import component.content.LabelForContentPanel;
import requestgenerator.form.RequestPanelWithCardNumber;

import javax.swing.*;
import java.util.Vector;

public class EnquiryPanel extends RequestPanelWithCardNumber {
    private static EnquiryPanel panel;

    private final JComboBox<String> enquiryType;
    private final JTextField chatLinkField;

    private final String ENQUIRY_TYPE_TEXT;

    {
        ENQUIRY_TYPE_TEXT = "Тип справки:";
        Vector<String> enquiryTypeStrings = new Vector<>();
        enquiryTypeStrings.add(panelName + " о отсутсвии задолеженности");
        enquiryTypeStrings.add(panelName + " о перевыпуске карты");
        enquiryTypeStrings.add(panelName + " о наличии карты (только с ФИО)");
        enquiryTypeStrings.add(panelName + " о наличии карты (с паспортом)");
        enquiryTypeStrings.add(panelName + " о закрытии счета");

        chatLinkField = getTextField();
        enquiryType = new ComboBoxForContentPanel<>(enquiryTypeStrings);
    }

    private EnquiryPanel() {
        super("Справка");

        add(new LabelForContentPanel(ENQUIRY_TYPE_TEXT));
        add(enquiryType);
        add(new LabelForContentPanel(CHAT_LINK_LABEL_TEXT));
        add(chatLinkField);
    }

    public static EnquiryPanel getInstance() {
        if (panel == null) panel = new EnquiryPanel();
        return panel;
    }

    @Override
    public String getAllText() {
        textBuilder
                .append(nameField.getText())
                .append(idField.getText())
                .append(phoneNumberField.getText())
                .append(cardNumberField.getText())
                .append((String) enquiryType.getSelectedItem())
                .append(chatLinkField.getText());
        return textBuilder.toString();
    }
}