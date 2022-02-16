package swing.code.gui.panel;

import swing.code.form.MainPanel;

public class DeliveryPanel extends MainPanel {
    private static DeliveryPanel panel;
    /*
    КЛАСС БУДЕТ СОДЕРЖАТЬ ТЕКСТОВЫЕ ПОЛЯ:
    ФИО
    ИНН
    НОМЕР ТЕЛЕФОНА
    LIST: ТИП ДОСТАВКИ
    КОММЕНТАРИЙ
     */

    public static DeliveryPanel getInstance(){
        if(panel == null) panel = new DeliveryPanel();
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
