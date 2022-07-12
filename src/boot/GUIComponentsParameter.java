package boot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public final class GUIComponentsParameter {
    public final static Color contentPanelBackgroundColor = new Color(255, 247, 244);
    public final static Color frameBackgroundColor = new Color(255, 239, 221);
    public final static Color buttonColor = new Color(255, 192, 138);
    public final static int MAIN_FRAME_X = 0;
    public final static int REQUEST_FRAME_X = 200;
    public final static int PERCENTAGE_FRAME_X = 400;
    public final static int RAW_PERCENTAGE_FRAME_X = 600;
    public final static int LOGGER_FRAME_X = 800;
    public final static int GLOBAL_INDENT_X = 5;
    public final static int GLOBAL_INDENT_Y = 5;
    private final static int BORDER = 900;
    private final static int WIDTH_FULL_HD = 382;
    private final static int WIDTH_HD = 300;
    private static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private static final String fontName = "Default";
    private static final String os = System.getProperty("os.name");
    private static final String linux = "Linux";
    private final static int SCRIPT_GENERATOR_BUTTONS_IN_LINE = 2;
    private static Image icoImage = null;
    private GUIComponentsParameter() {
    }

    public static Dimension getScriptPanelDimension(int countOfButtons) {
        if (countOfButtons == 0) {
            return null;
        }
        int lines = countOfButtons % SCRIPT_GENERATOR_BUTTONS_IN_LINE == 0 ? countOfButtons / SCRIPT_GENERATOR_BUTTONS_IN_LINE : countOfButtons / SCRIPT_GENERATOR_BUTTONS_IN_LINE + 1;
        int width = GLOBAL_INDENT_X * (SCRIPT_GENERATOR_BUTTONS_IN_LINE + 1) + getScriptButtonDimension().width * SCRIPT_GENERATOR_BUTTONS_IN_LINE;
        int height = GLOBAL_INDENT_Y * (lines + 1) + getScriptButtonDimension().height * lines;
        return new Dimension(width, height);
    }

    public static Image getIcoImage(){
        if(icoImage == null){
            try{
                icoImage = ImageIO.read(GUIComponentsParameter.class.getResource("/resources/ico.jpg"));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        return icoImage;
    }

    public static Dimension getTextFieldDimension() {
        int height = 19;
        int width = getRequestPanelDimension().width - 10;
        return new Dimension(width, height);
    }

    public static Font getControlPanelFont() {
        if (screenSize.height > BORDER) {
            return new Font(fontName, Font.BOLD, 10);
        } else return new Font(fontName, Font.BOLD, 8);
    }

    public static Font getButtonForControlPanelFont() {
        if (screenSize.height > BORDER) {
            return new Font(fontName, Font.BOLD, 10);
        } else return new Font(fontName, Font.BOLD, 9);
    }

    public static Font getContentPanelFont() {
        if (screenSize.height > BORDER) {
            return new Font(fontName, Font.PLAIN, 11);
        } else return new Font(fontName, Font.PLAIN, 9);
    }

    public static Dimension getDaemonPanelDimension() {
        if (screenSize.height > BORDER) {
            return new Dimension(120, 202);
        } else return new Dimension(105, 165);
    }

    public static Dimension getRequestPanelDimension() {
        if (os.equals(linux)) {
            if (screenSize.height > BORDER) {
                return new Dimension(WIDTH_FULL_HD + 5, 550);
            } else return new Dimension(WIDTH_HD + 20, 452);
        } else {
            if (screenSize.height > BORDER) {
                return new Dimension(WIDTH_FULL_HD, 580);
            } else return new Dimension(WIDTH_HD, 475);
        }
    }

    public static Dimension getPercentageGeneratorPanelDimension() {
        if (os.equals(linux)) {
            if (screenSize.height > BORDER) {
                return new Dimension(WIDTH_FULL_HD + 5, 640);
            } else return new Dimension(WIDTH_HD + 20, 485);
        } else {
            if (screenSize.height > BORDER) {
                return new Dimension(WIDTH_FULL_HD, 795);
            } else return new Dimension(WIDTH_HD, 485);
        }
    }

    public static JTextArea getTextAreaForRawResultPanel() {
        JTextArea textArea = new JTextArea();
        textArea.setFont(getControlPanelFont());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        if (os.equals(linux)) {
            if (screenSize.height > BORDER) {
                textArea.setColumns(34);
                textArea.setRows(19);
            } else {
                textArea.setColumns(36);
                textArea.setRows(16);
            }
        } else {
            if (screenSize.height > BORDER) {
                textArea.setColumns(41);
                textArea.setRows(18);
            } else {
                textArea.setColumns(41);
                textArea.setRows(16);
            }
        }
        return textArea;
    }

    public static JTextArea getTextAreaForLogger() {
        JTextArea textArea = new JTextArea(30, 26);
        textArea.setFont(new Font(fontName, Font.BOLD, 11));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        return textArea;
    }

    public static JTextArea getTextAreaForLMainPanel() {
        JTextArea textArea = new JTextArea();
        if (screenSize.height > BORDER) {
            textArea.setRows(6);
            textArea.setColumns(10);
        } else {
            textArea.setRows(5);
            textArea.setColumns(8);
        }
        textArea.setFont(new Font(fontName, Font.PLAIN, 10));
        textArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        return textArea;
    }

    public static Dimension getRawResultPanelDimension() {
        if (os.equals(linux)) {
            if (screenSize.height > BORDER) {
                return new Dimension(WIDTH_FULL_HD + 5, 305);
            } else return new Dimension(WIDTH_HD, 210);
        } else {
            if (screenSize.height > BORDER) {
                return new Dimension(WIDTH_FULL_HD, 310);
            } else return new Dimension(WIDTH_HD, 210);
        }
    }

    public static Dimension getControlPanelDimension() {
        if (screenSize.height > BORDER) {
            return new Dimension(WIDTH_FULL_HD, 40);
        } else return new Dimension(WIDTH_HD, 33);
    }

    public static Dimension getContentButtonDimension() {
        if (screenSize.height > BORDER) {
            return new Dimension(200, 20);
        } else return new Dimension(170, 15);
    }

    public static Dimension getScriptButtonDimension() {
        if (screenSize.height > BORDER) {
            return new Dimension(200, 30);
        } else return new Dimension(190, 25);
    }

    public static Dimension getControlButtonDimension() {
        if (screenSize.height > BORDER) {
            return new Dimension(110, 30);
        } else return new Dimension(88, 24);
    }

    public static int getTextAreaRows() {
        if (screenSize.height > BORDER) {
            return 4;
        } else return 2;
    }

    public static int getTextAreaColumns() {
        if (os.equals(linux)) {
            if (screenSize.height > BORDER) {
                return 34;
            } else return 34;
        } else {
            if (screenSize.height > BORDER) {
                return 41;
            } else return 36;
        }
    }
}
