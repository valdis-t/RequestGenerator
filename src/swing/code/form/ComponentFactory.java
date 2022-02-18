package swing.code.form;

import javax.swing.*;

public interface ComponentFactory{
    JLabel NAME_LABEL = new JLabel("ФИО:");
    JLabel ID_LABEL = new JLabel("ИНН:");
    JLabel PHONE_NUMBER_LABEL = new JLabel("Фин.номер телефона:");
    JLabel CARD_NUMBER_LABEL = new JLabel("Номер карты:");
    JLabel LINK_TO_CHAT_LABEL = new JLabel("Ссылка на чат:");
    JLabel COMMENTARY_LABEL = new JLabel("Комментарий:");

    default JTextField getTextField(){
        return new JTextField(ComponentSize.TEXT_AREA_COLUMNS);
    }

    default JTextArea getTextArea(){
        return new JTextArea(ComponentSize.TEXT_AREA_ROWS, ComponentSize.TEXT_AREA_COLUMNS);
    }
}
