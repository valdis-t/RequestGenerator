package requestgenerator.form;

import common.gui.panel.MainPanel;
import component.content.LabelForContentPanel;

import javax.swing.*;

public abstract class RequestPanel extends MainPanel {
    protected final String NAME_LABEL_TEXT = "ФИО:";
    protected final String ID_LABEL_TEXT = "ИНН:";
    protected final String PHONE_NUMBER_LABEL_TEXT = "Фин.номер телефона:";
    protected final String CARD_NUMBER_LABEL_TEXT = "Номер карты:";
    protected final String CHAT_LINK_LABEL_TEXT = "Ссылка на чат:";
    protected final String COMMENTARY_LABEL_TEXT = "Комментарий:";
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