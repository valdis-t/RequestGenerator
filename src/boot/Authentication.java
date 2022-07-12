package boot;

import util.file.FileManager;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Authentication {
    private static final Map<String, LocalDate> keys;
    private static String allowedText;

    static {
        keys = new HashMap<>();
        keys.put("IFHNTJBAJY", LocalDate.of(2022, 6, 1));
        keys.put("HGKLQNGFHM", LocalDate.of(2030, 1, 1));
        allowedText = "APP IS NOT INITIALIZED -> CALL TO APP OWNER";
    }

    private Authentication() {
    }

    public static void initialize() {
        String userKey = FileManager.getManager().getKey();
        keys.forEach((key, date) -> {
            if (key.equals(userKey.trim()) && (date.isAfter(LocalDate.now()) || date.isEqual(LocalDate.now()))) {
                allowedText = "";
                return;
            }
        });
    }

    public static String getAllowedText() {
        return allowedText;
    }
}
