package swing.code.gui.panel;

import swing.code.form.ComponentSize;
import swing.code.form.Readable;
import swing.code.gui.layout.MainPanelLayoutManager;

import javax.swing.*;

public class CashBackPanel extends JPanel implements Readable {
    private static CashBackPanel panel;

    private static final String EMPTY = "";

    private JTextField nameField;
    private JTextField idField;
    private JTextField phoneNumberField;
    private JTextField merchantField;
    private JTextField merchantNameField;
    private JTextField mccField;
    private JTextField operationDateField;
    private JTextField amountField;
    private JTextField addressOfStoreField;
    private JTextField chatLinkField;


    private CashBackPanel(){
        JLabel nameFieldLabel = new JLabel("ФИО клиента:");
        JLabel idFieldLabel = new JLabel("ИНН клиента:");
        JLabel phoneNumberLabel = new JLabel("Номер телефона клиента:");
        JLabel merchantFieldLabel = new JLabel("Merchant");
        JLabel merchantNameFieldLabel = new JLabel("Merchant-name");
        JLabel mccFieldLabel = new JLabel("МСС-код:");
        JLabel operationDateFieldLabel = new JLabel("Дата операции:");
        JLabel amountFieldLabel = new JLabel("Сумма покупки:");
        JLabel addressOfStoreFieldLabel = new JLabel("Адрес/ссылка магазина:");
        JLabel chatLinkFieldLabel = new JLabel("Ссылка на чат:");

        nameField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
        idField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
        phoneNumberField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
        merchantField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
        merchantNameField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
        mccField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
        operationDateField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
        amountField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
        addressOfStoreField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
        chatLinkField = new JTextField(ComponentSize.TEXT_AREA_COLUMNS);

        this.setSize(ComponentSize.WINDOWS_WIDTH,ComponentSize.MAIN_PANEL_HEIGHT);
        this.setLayout(new MainPanelLayoutManager());
        this.add(nameFieldLabel);
        this.add(nameField);
        this.add(idFieldLabel);
        this.add(idField);
        this.add(phoneNumberLabel);
        this.add(phoneNumberField);
        this.add(merchantFieldLabel);
        this.add(merchantField);
        this.add(merchantNameFieldLabel);
        this.add(merchantNameField);
        this.add(mccFieldLabel);
        this.add(mccField);
        this.add(operationDateFieldLabel);
        this.add(operationDateField);
        this.add(amountFieldLabel);
        this.add(amountField);
        this.add(addressOfStoreFieldLabel);
        this.add(addressOfStoreField);
        this.add(chatLinkFieldLabel);
        this.add(chatLinkField);
    }

    public static CashBackPanel getInstance(){
        if(panel == null) panel = new CashBackPanel();
        return panel;
    }

    @Override
    public String getAllText() {
        if(
                        nameField.getText().trim().equals(EMPTY) ||
                        idField.getText().trim().equals(EMPTY) ||
                        phoneNumberField.getText().trim().equals(EMPTY) ||
                        merchantField.getText().trim().equals(EMPTY) ||
                        merchantNameField.getText().trim().equals(EMPTY) ||
                        mccField.getText().trim().equals(EMPTY) ||
                        operationDateField.getText().trim().equals(EMPTY) ||
                        amountField.getText().trim().equals(EMPTY) ||
                        chatLinkField.getText().trim().equals(EMPTY)
        ) return "Некорректный запрос!";
        StringBuilder buffer = new StringBuilder();
        buffer
                .append(nameField.getText())
                .append("\n")
                .append(idField.getText())
                .append("\n")
                .append(phoneNumberField.getText())
                .append("\n")
                .append(merchantField.getText())
                .append("\n")
                .append(merchantNameField.getText())
                .append("\n")
                .append(mccField.getText())
                .append("\n")
                .append(operationDateField.getText())
                .append("\n")
                .append(amountField.getText())
                .append("\n");
        if (!addressOfStoreField.getText().trim().equals(EMPTY)) buffer.append(addressOfStoreField.getText()).append("\n");
        buffer.append(chatLinkField.getText());
        return buffer.toString();
    }

    @Override
    public void cleanAllFields() {
        nameField.setText(EMPTY);
        idField.setText(EMPTY);
        phoneNumberField.setText(EMPTY);
        merchantField.setText(EMPTY);
        merchantNameField.setText(EMPTY);
        mccField.setText(EMPTY);
        operationDateField.setText(EMPTY);
        amountField.setText(EMPTY);
        addressOfStoreField.setText(EMPTY);
        chatLinkField.setText(EMPTY);
    }
}
