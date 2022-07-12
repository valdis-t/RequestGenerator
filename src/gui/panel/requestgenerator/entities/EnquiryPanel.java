package gui.panel.requestgenerator.entities;

import gui.component.content.ComboBoxForContentPanel;
import gui.component.content.LabelForContentPanel;
import gui.panel.requestgenerator.RequestPanelWithCardNumber;

import javax.swing.*;
import java.util.Vector;

public class EnquiryPanel extends RequestPanelWithCardNumber {
    private final JComboBox<String> enquiryType;
    private final JTextField chatLinkField;

    private final String ENQUIRY_TYPE_TEXT;

    {
        ENQUIRY_TYPE_TEXT = "Тип справки:";
        Vector<String> enquiryTypeStrings = new Vector<>();
        enquiryTypeStrings.add(panelName + " про відсутність заборгованості");
        enquiryTypeStrings.add(panelName + " про перевипуск картки");
        enquiryTypeStrings.add(panelName + " про наявність картки (тільки з ПІБ)");
        enquiryTypeStrings.add(panelName + " про наявність картки (з паспортом)");
        enquiryTypeStrings.add(panelName + " про закриття рахунку");

        chatLinkField = getTextField();
        enquiryType = new ComboBoxForContentPanel<>(enquiryTypeStrings);
    }

    public EnquiryPanel() {
        super("Довідка");
        nameForAnalyticKey = panelName;
        add(new LabelForContentPanel(ENQUIRY_TYPE_TEXT));
        add(enquiryType);
        add(new LabelForContentPanel(CHAT_LINK_LABEL_TEXT));
        add(chatLinkField);
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