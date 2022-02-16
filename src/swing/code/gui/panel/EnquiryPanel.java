package swing.code.gui.panel;

import swing.code.form.MainPanel;

public class EnquiryPanel extends MainPanel {
    private static EnquiryPanel panel;
    /*
    КЛАСС БУДЕТ СОДЕРЖАТЬ ТЕКСТОВЫЕ ПОЛЯ:
    ФИО
    ИНН
    НОМЕР ТЕЛЕФОНА
    НОМЕР КАРТЫ
    LIST: ТИП СПРАВКИ
    ССЫЛКА НА ЧАТ
     */
    public static EnquiryPanel getInstance(){
        if(panel == null) panel = new EnquiryPanel();
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
