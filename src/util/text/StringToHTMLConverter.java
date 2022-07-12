package util.text;

public class StringToHTMLConverter {
    public static String convertForGUIComponent(String text) {
        if (text == null || text.trim().equals("")) return "empty";
        String[] words = text.split(" ");
        String regex = "<br>";
        StringBuilder builder = new StringBuilder("<html>");
        for (String current : text.split(" ")) {
            builder.append(current).append(regex);
        }
        builder.delete(builder.lastIndexOf(regex), builder.length()).append("</html>");
        return builder.toString();
    }
}
