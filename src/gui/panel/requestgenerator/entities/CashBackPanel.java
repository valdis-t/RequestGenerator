package gui.panel.requestgenerator.entities;

import gui.component.content.LabelForContentPanel;
import gui.panel.requestgenerator.RequestPanel;
import util.text.StringDefaultValue;

import javax.swing.*;

public class CashBackPanel extends RequestPanel {
    private final JTextField merchantField;
    private final JTextField merchantNameField;
    private final JTextField terminalField;
    private final JTextField mccField;
    private final JTextField operationDateField;
    private final JTextField amountField;
    private final JTextField addressOfStoreField;
    private final JTextArea commentaryField;
    private final JTextField chatLinkField;

    private final String MERCHANT_LOGIC_TEXT;
    private final String MERCHANT_NAME_LOGIC_TEXT;
    private final String TERMINAL_LOGIC_TEXT;
    private final String MCC_LOGIC_TEXT;
    private final String OPERATION_DATE_LOGIC_TEXT;
    private final String AMOUNT_LOGIC_TEXT;
    private final String ADDRESS_LOGIC_TEXT;
    private final String MERCHANT_LABEL_TEXT;
    private final String MERCHANT_NAME_LABEL_TEXT;
    private final String TERMINAL_LABEL_TEXT;
    private final String MCC_LABEL_TEXT;
    private final String OPERATION_DATE_LABEL_TEXT;
    private final String AMOUNT_LABEL_TEXT;
    private final String ADDRESS_LABEL_TEXT;

    {
        MERCHANT_LOGIC_TEXT = "Merchant: ";
        MERCHANT_NAME_LOGIC_TEXT = "Merchant name: ";
        TERMINAL_LOGIC_TEXT = "Term id: ";
        MCC_LOGIC_TEXT = "MCC: ";
        OPERATION_DATE_LOGIC_TEXT = "Дата: ";
        AMOUNT_LOGIC_TEXT = "Сума: ";
        ADDRESS_LOGIC_TEXT = "Адреса: ";
        MERCHANT_LABEL_TEXT = "Ретейлер:";
        MERCHANT_NAME_LABEL_TEXT = "Власник:";
        TERMINAL_LABEL_TEXT = "Термінал:";
        MCC_LABEL_TEXT = "Категорія:";
        OPERATION_DATE_LABEL_TEXT = "Дата/час:";
        AMOUNT_LABEL_TEXT = AMOUNT_LOGIC_TEXT;
        ADDRESS_LABEL_TEXT = "Адреса торгівельної точки:";

        merchantField = getTextField();
        merchantNameField = getTextField();
        terminalField = getTextField();
        mccField = getTextField();
        operationDateField = getTextField();
        amountField = getTextField();
        addressOfStoreField = getTextField();
        commentaryField = getTextArea();
        chatLinkField = getTextField();
    }

    public CashBackPanel() {
        super("Кешбек");
        nameForAnalyticKey = panelName;
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.add(this);
        add(new LabelForContentPanel(OPERATION_DATE_LABEL_TEXT));
        add(operationDateField);
        add(new LabelForContentPanel(TERMINAL_LABEL_TEXT));
        add(terminalField);
        add(new LabelForContentPanel(AMOUNT_LABEL_TEXT));
        add(amountField);
        add(new LabelForContentPanel(MERCHANT_NAME_LABEL_TEXT));
        add(merchantNameField);
        add(new LabelForContentPanel(MERCHANT_LABEL_TEXT));
        add(merchantField);
        add(new LabelForContentPanel(MCC_LABEL_TEXT));
        add(mccField);
        add(new LabelForContentPanel(ADDRESS_LABEL_TEXT));
        add(addressOfStoreField);
        add(new LabelForContentPanel(COMMENTARY_LABEL_TEXT));
        add(commentaryField);
        add(new LabelForContentPanel(CHAT_LINK_LABEL_TEXT));
        add(chatLinkField);
    }

    @Override
    public String getAllText() {
        textBuilder
                .append(nameField.getText())
                .append(idField.getText())
                .append(phoneNumberField.getText())
                .append(StringDefaultValue.NEW_LINE_TEXT)
                .append(commentaryField.getText())
                .append(StringDefaultValue.NEW_LINE_TEXT)
                .append(operationDateField.getText(), OPERATION_DATE_LOGIC_TEXT)
                .append(terminalField.getText(), TERMINAL_LOGIC_TEXT)
                .append(amountField.getText(), AMOUNT_LOGIC_TEXT)
                .append(merchantField.getText(), MERCHANT_LOGIC_TEXT)
                .append(merchantNameField.getText(), MERCHANT_NAME_LOGIC_TEXT)
                .append(mccField.getText(), MCC_LOGIC_TEXT)
                .append(addressOfStoreField.getText(), ADDRESS_LOGIC_TEXT)
                .append(chatLinkField.getText());
        return textBuilder.toString();
    }
}