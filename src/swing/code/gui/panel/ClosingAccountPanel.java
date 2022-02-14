package swing.code.gui.panel;

import swing.code.form.ComponentSize;
import swing.code.form.MainPanel;
import swing.code.gui.layout.MainPanelLayoutManager;

import javax.swing.*;

public class ClosingAccountPanel extends MainPanel {
    /*
    КЛАСС БУДЕТ СОДЕРЖАТЬ ПОЛЯ:
    ФИО
    ИНН
    НОМЕР ТЕЛЕФОНА
    НОМЕР КАРТЫ
    БАЛАНС
    CHECK_BOX: БЛОК ФРОД
    ССЫЛКА НА ЧАТ
     */
    private static ClosingAccountPanel panel;

    private static final String phoneChangingText = "";

    private JTextField nameField;
    private JTextField idField;
    private JTextField phoneNumberField;
    private JTextField cardNumberField;
    private JTextArea balance;
    private JCheckBox isFraudBlocked;
    private JTextField chatLinkField;

    private ClosingAccountPanel(){
        JLabel nameFieldLabel = new JLabel("ФИО клиента:");
        JLabel idFieldLabel = new JLabel("ИНН клиента:");
        JLabel phoneNumberLabel = new JLabel("Номер телефона клиента:");
        JLabel cardFieldLabel = new JLabel("Номер карты:");
        JLabel balanceLabel = new JLabel("Баланс:");
        JLabel chatLinkFieldLabel = new JLabel("Ссылка на чат:");

        nameField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
        idField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
        phoneNumberField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);

        cardNumberField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
        balance = new JTextArea(ComponentSize.TEXT_AREA_ROWS, ComponentSize.TEXT_AREA_COLUMNS);
        JScrollPane scrollPane = new JScrollPane(balance);
        chatLinkField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);

        ButtonGroup checkGroup = new ButtonGroup();
        JPanel checkPanel = new JPanel();
        checkPanel.setSize(ComponentSize.WINDOWS_WIDTH,ComponentSize.CHECK_BOX_HEIGHT);
        BoxLayout checkLayout = new BoxLayout(checkPanel,BoxLayout.X_AXIS);
        isFraudBlocked = new JCheckBox("Номер карты");
        checkGroup.add(isFraudBlocked);
        checkPanel.setLayout(checkLayout);
        checkPanel.add(isFraudBlocked);

        this.setSize(ComponentSize.WINDOWS_WIDTH,ComponentSize.MAIN_PANEL_HEIGHT);
        this.setLayout(new MainPanelLayoutManager());
        this.add(nameFieldLabel);
        this.add(nameField);
        this.add(idFieldLabel);
        this.add(idField);
        this.add(phoneNumberLabel);
        this.add(phoneNumberField);
        this.add(cardFieldLabel);
        this.add(checkPanel);
        this.add(cardNumberField);
        this.add(balanceLabel);
        this.add(scrollPane);
        this.add(chatLinkFieldLabel);
        this.add(chatLinkField);
    }

    public static ClosingAccountPanel getInstance(){
        if(panel==null) panel = new ClosingAccountPanel();
        return panel;
    }

    @Override
    public String getAllText() {
        if (
                nameField.getText().trim().equals(EMPTY) ||
                        idField.getText().trim().equals(EMPTY) ||
                        phoneNumberField.getText().trim().equals(EMPTY) ||
                        balance.getText().trim().equals(EMPTY)
        ) return WRONG_REQUEST;
        StringBuilder buffer = new StringBuilder();
        buffer
                .append(nameField.getText())
                .append(NEW_LINE)
                .append(idField.getText())
                .append(NEW_LINE)
                .append(phoneNumberField.getText())
                .append(NEW_LINE);
        if (isFraudBlocked.isSelected()){
            buffer.append("есть блок от фрод").append(NEW_LINE);
        }

        buffer.append(balance.getText());
        if(!chatLinkField.getText().trim().equals(EMPTY)) buffer.append(NEW_LINE).append(NEW_LINE).append(chatLinkField.getText());

        return buffer.toString();
    }

    @Override
    public void cleanAllFields() {
        isFraudBlocked.setSelected(false);
        nameField.setText(EMPTY);
        idField.setText(EMPTY);
        phoneNumberField.setText(EMPTY);
        cardNumberField.setText(EMPTY);
        balance.setText(EMPTY);
        chatLinkField.setText(EMPTY);
    }
}
