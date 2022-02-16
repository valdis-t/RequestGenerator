package swing.code.gui.panel;

import swing.code.form.MainPanel;

public class FraudPanel extends MainPanel {
    private static FraudPanel panel;
    /*
    КЛАСС БУДЕТ СОДЕРЖАТЬ ТЕКСТОВЫЕ ПОЛЯ:
    ФИО
    ИНН
    НОМЕР ТЕЛЕФОНА
    НОМЕР КАРТЫ
    ПРИЧИНА БЛОКИРОВКИ
    КОММЕНТАРИЙ
     */
    public static FraudPanel getInstance(){
        if(panel == null) panel = new FraudPanel();
        return panel;
    }

    @Override
    public String getAllText() {
        return null;
    }

    @Override
    public void cleanAllFields() {

    }
}
