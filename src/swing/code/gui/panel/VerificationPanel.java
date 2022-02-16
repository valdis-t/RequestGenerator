package swing.code.gui.panel;

import swing.code.form.MainPanel;

public class VerificationPanel extends MainPanel {
    private static VerificationPanel panel;
    /*
    КЛАСС БУДЕТ СОДЕРЖАТЬ ПОЛЯ:
    ФИО
    ИНН
    НОМЕР ТЕЛЕФОНА
    CHECK_BOX: НА УДЕРЖАНИИ
    CHECK_BOX: НОВЫЕ ДОКУМЕНТЫ
    КОММЕНТАРИЙ
    */
    public static VerificationPanel getInstance(){
        if(panel == null) panel = new VerificationPanel();
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
