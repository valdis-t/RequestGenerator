package gui.panel.requestgenerator.entities;

import gui.component.content.*;
import gui.panel.requestgenerator.RequestPanel;
import util.text.StringDefaultValue;

import javax.swing.*;

public class MainRequestPanel extends RequestPanel {
    private final String ADDITIONAL_FIELD_LABEL_TEXT;
    private final String HAS_FINANCIAL_NUMBER_TEXT;
    private final String HAS_NOT_FINANCIAL_NUMBER_TEXT;
    private final String IS_WAITING_PHOTO_TEXT;
    private final String PHONE_CHANGING_TEXT;
    private final String CHECK_PIN_TEXT;
    private final String TEMPORARY_PIN_TEXT;
    private final String EMAIL_CHANGING_TEXT;
    private final String SUCCESS_TEXT;
    private final String RESPONSE_MODE;
    private final JRadioButton isResponseMode;
    private final JButton hasAccessToPhone;
    private final JCheckBox isWaitingPhoto;

    private final JCheckBox isPhoneChanging;
    private final JCheckBox isTemporaryPIN;
    private final JCheckBox isCheckPIN;
    private final JCheckBox isMailAdding;

    private final JPanel responsePanel;

    private final JCheckBox identifySuccessful;
    private final JCheckBox documentsSuccessful;
    private final JCheckBox jobSuccessful;
    private final JCheckBox responseSuccessful;

    private final JTextField additionalField;
    private final JTextArea commentaryField;
    private final JLabel additionalFieldLabel;

    {
        IS_WAITING_PHOTO_TEXT = "чекаю на фото";
        ADDITIONAL_FIELD_LABEL_TEXT = StringDefaultValue.EMPTY_TEXT;
        RESPONSE_MODE = "режим звіту";
        HAS_FINANCIAL_NUMBER_TEXT = "ідентифікація по фін. номеру";
        HAS_NOT_FINANCIAL_NUMBER_TEXT = "відеоідентифікація";
        PHONE_CHANGING_TEXT = "зміна фін. номера";
        CHECK_PIN_TEXT = "чек-пін";
        TEMPORARY_PIN_TEXT = "тимчасовий пін";
        EMAIL_CHANGING_TEXT = "прив'язка email";
        SUCCESS_TEXT = "+";
        additionalFieldLabel = new LabelForContentPanel(ADDITIONAL_FIELD_LABEL_TEXT);

        isResponseMode = new RadioButtonForContentPanel(RESPONSE_MODE);
        hasAccessToPhone = new ButtonForContentPanel(HAS_FINANCIAL_NUMBER_TEXT);
        additionalField = getTextField();
        commentaryField = getTextArea();

        isWaitingPhoto = new CheckBoxForContentPanel(IS_WAITING_PHOTO_TEXT);
        isTemporaryPIN = new CheckBoxForContentPanel(TEMPORARY_PIN_TEXT);
        isPhoneChanging = new CheckBoxForContentPanel(PHONE_CHANGING_TEXT);
        isCheckPIN = new CheckBoxForContentPanel(CHECK_PIN_TEXT);
        isMailAdding = new CheckBoxForContentPanel(EMAIL_CHANGING_TEXT);

        responsePanel = new VerticalPanelForContentPanel();
        identifySuccessful = new CheckBoxForContentPanel(hasAccessToPhone.getText() + SUCCESS_TEXT);
        documentsSuccessful = new CheckBoxForContentPanel("паспорт" + SUCCESS_TEXT);
        jobSuccessful = new CheckBoxForContentPanel(isPhoneChanging.getText() + SUCCESS_TEXT);
        responseSuccessful = new CheckBoxForContentPanel("ос" + SUCCESS_TEXT);
    }

    public MainRequestPanel() {
        super("Основні запити");
        cleanAllFields();
        add(isResponseMode);
        add(hasAccessToPhone);
        add(isWaitingPhoto);
        add(getJobPanel());
        additionalField.setEnabled(false);
        add(additionalFieldLabel);
        add(additionalField);
        add(new LabelForContentPanel("Посилання/комментар:"));
        add(commentaryField);
        setupResponsePanel();
        add(responsePanel);
        addActions();
    }

    @Override
    public String getAllText() {
        if (isTemporaryPIN.isSelected() || isCheckPIN.isSelected()) nameForAnalyticKey = "зміна пін";
        else if (isPhoneChanging.isSelected()) nameForAnalyticKey = isPhoneChanging.getText();
        else if (isMailAdding.isSelected()) nameForAnalyticKey = isMailAdding.getText();
        else nameForAnalyticKey = "загальні питання";

        textBuilder
                .append(nameField.getText())
                .append(idField.getText())
                .append(phoneNumberField.getText());
        if (isPhoneChanging.isSelected()) textBuilder.append("- новий номер", additionalField.getText());
        else textBuilder.append(additionalField.getText());
        if (isResponseMode.isSelected()) {
            textBuilder
                    .append(identifySuccessful.isSelected(), identifySuccessful.getText(), "ІДЕНТ НЕ ПРОЙШОВ?")
                    .append(documentsSuccessful.isSelected(), documentsSuccessful.getText(), "ДОКУМЕНТ НЕ ПІДХОДИТЬ?")
                    .append(jobSuccessful.isSelected(), jobSuccessful.getText(), "ЗАПИТ НЕ ВИКОНАНИЙ?")
                    .append(responseSuccessful.isSelected(), responseSuccessful.getText(), "ОС НЕ НАДАНА?");
        } else if (isWaitingPhoto.isSelected() && !isResponseMode.isSelected()) {
            textBuilder
                    .append(isCheckPIN.isSelected(), isCheckPIN.getText())
                    .append(isPhoneChanging.isSelected(), isPhoneChanging.getText())
                    .append(isMailAdding.isSelected(), isMailAdding.getText())
                    .append(isTemporaryPIN.isSelected(), isTemporaryPIN.getText())
                    .append(identifySuccessful.getText())
                    .append(isWaitingPhoto.getText());
        } else textBuilder
                .append(isCheckPIN.isSelected(), isCheckPIN.getText())
                .append(isPhoneChanging.isSelected(), isPhoneChanging.getText())
                .append(isMailAdding.isSelected(), isMailAdding.getText())
                .append(isTemporaryPIN.isSelected(), isTemporaryPIN.getText())
                .append("потрібна " + hasAccessToPhone.getText());
        textBuilder.append(commentaryField.getText());
        return textBuilder.toString();
    }

    @Override
    public void cleanAllFields() {
        super.cleanAllFields();
        responsePanel.setVisible(false);
        additionalFieldLabel.setText(ADDITIONAL_FIELD_LABEL_TEXT);
        additionalField.setText(StringDefaultValue.EMPTY_TEXT);
        additionalField.setEnabled(false);
        identifySuccessful.setSelected(false);
        documentsSuccessful.setSelected(false);
        jobSuccessful.setSelected(false);
        responseSuccessful.setSelected(false);

        hasAccessToPhone.setSelected(true);

        isPhoneChanging.setSelected(false);
        isTemporaryPIN.setSelected(false);
        isCheckPIN.setSelected(true);
        isMailAdding.setSelected(false);
    }

    private void setResponsePanelVisible(boolean value) {
        responsePanel.setVisible(value);
    }

    private void setJobSuccessfulText() {
        if (isTemporaryPIN.isSelected()) jobSuccessful.setText(isTemporaryPIN.getText() + SUCCESS_TEXT);
        if (isPhoneChanging.isSelected()) jobSuccessful.setText(isPhoneChanging.getText() + SUCCESS_TEXT);
        if (isCheckPIN.isSelected()) jobSuccessful.setText(isCheckPIN.getText() + SUCCESS_TEXT);
        if (isMailAdding.isSelected()) jobSuccessful.setText(isMailAdding.getText() + SUCCESS_TEXT);
    }

    private void setButtonText() {
        if (hasAccessToPhone.getText().equals(HAS_FINANCIAL_NUMBER_TEXT))
            hasAccessToPhone.setText(HAS_NOT_FINANCIAL_NUMBER_TEXT);
        else hasAccessToPhone.setText(HAS_FINANCIAL_NUMBER_TEXT);
    }

    private void setAdditionalFieldLabel() {
        if (isPhoneChanging.isSelected()) additionalFieldLabel.setText("Новий номер телефона:");
        else if (isMailAdding.isSelected()) additionalFieldLabel.setText("Новий email:");
        else additionalFieldLabel.setText(ADDITIONAL_FIELD_LABEL_TEXT);
    }

    private void setupResponsePanel() {
        responsePanel.add(identifySuccessful);
        responsePanel.add(documentsSuccessful);
        responsePanel.add(jobSuccessful);
        responsePanel.add(responseSuccessful);
        responsePanel.setVisible(false);
    }

    private void addActions() {
        hasAccessToPhone.addActionListener(l -> {
            setButtonText();
            identifySuccessful.setText(hasAccessToPhone.getText() + SUCCESS_TEXT);
        });
        isResponseMode.addActionListener(l -> {
            setResponsePanelVisible(isResponseMode.isSelected());
            isWaitingPhoto.setSelected(false);
        });
        isPhoneChanging.addActionListener(l -> {
            setJobSuccessfulText();
            setAdditionalFieldLabel();
            additionalField.setEnabled(true);
        });
        isMailAdding.addActionListener(l -> {
            setJobSuccessfulText();
            setAdditionalFieldLabel();
            additionalField.setEnabled(true);
        });
        isCheckPIN.addActionListener(l -> {
            setJobSuccessfulText();
            setAdditionalFieldLabel();
            additionalField.setText(StringDefaultValue.EMPTY_TEXT);
            additionalField.setEnabled(false);
        });
        isTemporaryPIN.addActionListener(l -> {
            setJobSuccessfulText();
            setAdditionalFieldLabel();
            additionalField.setText(StringDefaultValue.EMPTY_TEXT);
            additionalField.setEnabled(false);
        });
        isWaitingPhoto.addActionListener(l -> {
            setResponsePanelVisible(false);
            isResponseMode.setSelected(false);
        });
    }

    private JPanel getJobPanel() {
        JPanel panel = new VerticalPanelForContentPanel();
        ButtonGroup requestCheckGroup = new ButtonGroup();
        requestCheckGroup.add(isTemporaryPIN);
        requestCheckGroup.add(isPhoneChanging);
        requestCheckGroup.add(isCheckPIN);
        requestCheckGroup.add(isMailAdding);
        panel.add(isCheckPIN);
        panel.add(isTemporaryPIN);
        panel.add(isPhoneChanging);
        panel.add(isMailAdding);
        return panel;
    }

}
