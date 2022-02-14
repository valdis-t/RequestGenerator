package swing.code.util;

import swing.code.form.Readable;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.time.LocalDateTime;

public class Saver {
    public static void saveToFile(Readable readable){
        String string;
        if(readable != null){
            string = readable.getAllText();
        } else string = "Ошибка! Пустой объект.";
        System.out.println(LocalDateTime.now());
        System.out.println(string);
    }

    public static void saveToBuffer(Readable readable){
        String string;
        if(readable != null){
            string = readable.getAllText();
        } else string = "Ошибка! Пустой объект.";
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(string), null);
    }
}
