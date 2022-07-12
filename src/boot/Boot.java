package boot;

import gui.frame.MainFrame;

import java.time.LocalDate;

public class Boot {
    public static final String currentMonth = LocalDate.now().getYear() + "-0" + LocalDate.now().getMonthValue();

    private Boot() {
    }

    public static void run() {
        Authentication.initialize();
        new MainFrame().setVisible(true);
    }
}