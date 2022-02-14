package swing.code.form;

public interface ComponentSize {
    public static final int WINDOWS_HEIGHT = 750;
    public static final int WINDOWS_WIDTH = 480;
    public static final int SECONDARY_PANEL_HEIGHT = 100;
    public static final int MAIN_PANEL_HEIGHT = WINDOWS_HEIGHT - 2 * SECONDARY_PANEL_HEIGHT - 60;
    public static final int PANEL_WIDTH = WINDOWS_WIDTH - 25;
    public static final int CONTROL_BUTTON_HEIGHT = SECONDARY_PANEL_HEIGHT - 10;
    public static final int CONTROL_BUTTON_WIDTH = WINDOWS_WIDTH/3 - 5;
    public static final int CHECK_BOX_HEIGHT = 40;
    public static final int TEXT_AREA_COLUMNS = WINDOWS_WIDTH/10-4;
    public static final int TEXT_AREA_ROWS = 5;
}
