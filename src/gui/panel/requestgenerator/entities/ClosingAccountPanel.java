package gui.panel.requestgenerator.entities;

import gui.component.content.CheckBoxForContentPanel;
import gui.component.content.HorizontalPanelForContentPanel;
import gui.component.content.LabelForContentPanel;
import gui.panel.requestgenerator.RequestPanelWithCardNumber;

import javax.swing.*;

public class ClosingAccountPanel extends RequestPanelWithCardNumber {
    private final JTextField balanceField;
    private final JTextArea commentaryArea;
    private final JCheckBox isFraudBlocked;
    private final JCheckBox isArrested;
    private final JCheckBox hasDebt;
    private final JTextField chatLinkField;

    private final String BALANCE_LABEL_TEXT;
    private final String HAS_FRAUD_LOCKED_TEXT;
    private final String HAS_NOT_FRAUD_LOCKED_TEXT;
    private final String HAS_ARREST_TEXT;
    private final String HAS_NOT_ARREST_TEXT;
    private final String HAS_DEBT_TEXT;
    private final String HAS_NOT_DEBT_TEXT;

    {
        BALANCE_LABEL_TEXT = "Баланс: ";
        HAS_FRAUD_LOCKED_TEXT = "є блок від фрод";
        HAS_ARREST_TEXT = "є арешт";
        HAS_DEBT_TEXT = "є заборгованість";
        HAS_NOT_FRAUD_LOCKED_TEXT = "блокувань від фрод немає";
        HAS_NOT_ARREST_TEXT = "арештів немає";
        HAS_NOT_DEBT_TEXT = "заборгованостей немає";

        balanceField = getTextField();
        commentaryArea = getTextArea();
        chatLinkField = getTextField();

        isFraudBlocked = new CheckBoxForContentPanel(HAS_FRAUD_LOCKED_TEXT);
        isArrested = new CheckBoxForContentPanel(HAS_ARREST_TEXT);
        hasDebt = new CheckBoxForContentPanel(HAS_DEBT_TEXT);
    }

    public ClosingAccountPanel() {
        super("Закриття рахунку");
        nameForAnalyticKey = panelName;
        JPanel checkPanel = new HorizontalPanelForContentPanel();
        checkPanel.add(isFraudBlocked);
        checkPanel.add(isArrested);
        checkPanel.add(hasDebt);

        add(checkPanel);
        add(new LabelForContentPanel(BALANCE_LABEL_TEXT));
        add(balanceField);
        add(new LabelForContentPanel(COMMENTARY_LABEL_TEXT));
        add(commentaryArea);
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
                .append(balanceField.getText(), BALANCE_LABEL_TEXT)
                .append(isFraudBlocked.isSelected(), HAS_FRAUD_LOCKED_TEXT, HAS_NOT_FRAUD_LOCKED_TEXT)
                .append(isArrested.isSelected(), HAS_ARREST_TEXT, HAS_NOT_ARREST_TEXT)
                .append(hasDebt.isSelected(), HAS_DEBT_TEXT, HAS_NOT_DEBT_TEXT)
                .append(commentaryArea.getText())
                .append(chatLinkField.getText());
        return textBuilder.toString();
    }

    @Override
    public void cleanAllFields() {
        super.cleanAllFields();
        isFraudBlocked.setSelected(false);
        isArrested.setSelected(false);
        hasDebt.setSelected(false);
    }
}