package swing.code.gui.panel;

import swing.code.form.MainPanel;
import swing.code.gui.layout.MainPanelLayoutManager;
import swing.code.form.ComponentSize;

import javax.swing.*;

public class OldMainRequestPanel extends MainPanel {
    private static OldMainRequestPanel panel;

    private static final String phoneChangingText = "";

    private JTextField nameField;
    private JTextField idField;
    private JTextField phoneNumberField;
    private JCheckBox isCard;
    private JCheckBox isPhone;
    private JCheckBox isOther;
    private JTextField additionalField;
    private JTextArea commentaryField;
    private JTextField chatLinkField;

    private OldMainRequestPanel(){
        JLabel nameFieldLabel = new JLabel("ФИО клиента:");
        JLabel idFieldLabel = new JLabel("ИНН клиента:");
        JLabel phoneNumberLabel = new JLabel("Номер телефона клиента:");
        JLabel additionalFieldLabel = new JLabel("Дополнительное поле:");
        JLabel commentaryFieldLabel = new JLabel("Комментарий:");
        JLabel chatLinkFieldLabel = new JLabel("Ссылка на чат:");

        nameField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
        idField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
        phoneNumberField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
        additionalField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
        commentaryField = new JTextArea(ComponentSize.TEXT_AREA_ROWS, ComponentSize.TEXT_AREA_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(commentaryField);
        chatLinkField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);

        ButtonGroup checkGroup = new ButtonGroup();
        JPanel checkPanel = new JPanel();
        checkPanel.setSize(ComponentSize.WINDOWS_WIDTH,ComponentSize.CHECK_BOX_HEIGHT);
        BoxLayout checkLayout = new BoxLayout(checkPanel,BoxLayout.X_AXIS);
        isPhone = new JCheckBox("Смена номера");
        isCard = new JCheckBox("Номер карты");
        isOther = new JCheckBox("Пусто");
        isOther.setSelected(true);
        checkGroup.add(isPhone);
        checkGroup.add(isCard);
        checkGroup.add(isOther);
        checkPanel.setLayout(checkLayout);
        checkPanel.add(isPhone);
        checkPanel.add(isCard);
        checkPanel.add(isOther);

        this.setSize(ComponentSize.WINDOWS_WIDTH,ComponentSize.MAIN_PANEL_HEIGHT);
        this.setLayout(new MainPanelLayoutManager());
        this.add(nameFieldLabel);
        this.add(nameField);
        this.add(idFieldLabel);
        this.add(idField);
        this.add(phoneNumberLabel);
        this.add(phoneNumberField);
        this.add(additionalFieldLabel);
        this.add(checkPanel);
        this.add(additionalField);
        this.add(commentaryFieldLabel);
        this.add(scrollPane);
        this.add(chatLinkFieldLabel);
        this.add(chatLinkField);
    }

    public static OldMainRequestPanel getInstance(){
        if(panel==null) panel = new OldMainRequestPanel();
        return panel;
    }

    @Override
    public String getAllText() {
        if (
                                nameField.getText().trim().equals(EMPTY) ||
                                idField.getText().trim().equals(EMPTY) ||
                                phoneNumberField.getText().trim().equals(EMPTY) ||
                                commentaryField.getText().trim().equals(EMPTY)
        ) return WRONG_REQUEST;
        StringBuilder buffer = new StringBuilder();
        buffer
                .append(nameField.getText())
                .append(NEW_LINE)
                .append(idField.getText())
                .append(NEW_LINE)
                .append(phoneNumberField.getText())
                .append(NEW_LINE);
        if(isPhone.isSelected()){
            if(additionalField.getText().trim().equals(EMPTY)) return WRONG_REQUEST;
            buffer.append("смена на ").append(additionalField.getText()).append(NEW_LINE);
        }
        else if (isCard.isSelected()){
            if(additionalField.getText().trim().equals(EMPTY)) return WRONG_REQUEST;
            buffer.append(additionalField.getText()).append(NEW_LINE);
        }

        buffer.append("\n").append(commentaryField.getText());
        if(!chatLinkField.getText().trim().equals(EMPTY)) buffer.append(NEW_LINE).append(NEW_LINE).append(chatLinkField.getText());

        return buffer.toString();
    }

    @Override
    public void cleanAllFields() {
        nameField.setText(EMPTY);
        idField.setText(EMPTY);
        phoneNumberField.setText(EMPTY);
        additionalField.setText(EMPTY);
        commentaryField.setText(EMPTY);
        chatLinkField.setText(EMPTY);
    }
}
