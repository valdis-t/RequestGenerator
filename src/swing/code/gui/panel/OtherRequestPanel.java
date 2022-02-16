package swing.code.gui.panel;

import swing.code.form.MainPanel;

public class OtherRequestPanel extends MainPanel {
    private static OtherRequestPanel panel;
    /*
    КЛАСС БУДЕТ СОДЕРЖАТЬ ПОЛЯ:
    ФИО
    ИНН
    НОМЕР ТЕЛЕФОНА
    КОММЕНТАРИЙ
     */
    public static OtherRequestPanel getInstance(){
        if(panel == null) panel = new OtherRequestPanel();
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
