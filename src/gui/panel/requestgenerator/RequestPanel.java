package gui.panel.requestgenerator;

import gui.component.content.LabelForContentPanel;
import gui.panel.MainPanel;

import javax.swing.*;

public abstract class RequestPanel extends MainPanel {
    protected final String NAME_LABEL_TEXT = "ПІБ:";
    protected final String ID_LABEL_TEXT = "ІПН:";
    protected final String PHONE_NUMBER_LABEL_TEXT = "Фін.номер телефону:";
    protected final String CARD_NUMBER_LABEL_TEXT = "Номер картки:";
    protected final String CHAT_LINK_LABEL_TEXT = "Посилання на чат:";
    protected final String COMMENTARY_LABEL_TEXT = "Коментар:";
    protected final JTextField nameField;
    protected final JTextField idField;
    protected final JTextField phoneNumberField;

    protected RequestPanel(String panelName) {
        super(panelName);
        nameField = getTextField();
        idField = getTextField();
        phoneNumberField = getTextField();

        add(new LabelForContentPanel(NAME_LABEL_TEXT));
        add(nameField);
        add(new LabelForContentPanel(ID_LABEL_TEXT));
        add(idField);
        add(new LabelForContentPanel(PHONE_NUMBER_LABEL_TEXT));
        add(phoneNumberField);
    }
}