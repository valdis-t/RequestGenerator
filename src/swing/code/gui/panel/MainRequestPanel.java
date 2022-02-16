package swing.code.gui.panel;

import swing.code.form.MainPanel;

public class MainRequestPanel extends MainPanel {
    private static MainRequestPanel panel;
    /*
    КЛАСС БУДЕТ СОДЕРЖАТЬ ПОЛЯ:
    ФИО
    ИНН
    НОМЕР ТЕЛЕФОНА
    CHECK_BOX: ЕСЛИ ЛИ ФИНАНСОВИЙ НОМЕР
    CHECK_BOX: СМЕНА НОМЕРА
    CHECK_BOX: ВРЕМЕННЫЙ ПИН
    CHECK_BOX: ЧЕК ПИН
    КОММЕНТАРИЙ
    ССЫЛКА НА ЧАТ
     */
    public static MainRequestPanel getInstance(){
        if(panel == null) panel = new MainRequestPanel();
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
