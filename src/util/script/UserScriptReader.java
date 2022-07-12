package util.script;

import java.util.LinkedList;
import java.util.List;

public class UserScriptReader {
    private final List<ScriptContainer> scripts = new LinkedList<>();
    private final String nameTag = "name=";
    private final String bodyTag = "body=";
    private final int nameLength = nameTag.length();
    private final int bodyLength = bodyTag.length();
    private final int backspace = -2; //for deleting '/r/n' after 'body' text from text-source

    public UserScriptReader(String scriptSource) {
        parse(scriptSource);
    }

    public List<ScriptContainer> getScripts() {
        return scripts;
    }

    public String[][] getScriptsAsArray() {
        String[][] array = new String[2][scripts.size()];
        for (int i = 0; i < scripts.size(); ++i) {
            array[0][i] = scripts.get(i).getName();
            array[1][i] = scripts.get(i).getBody();
        }
        return array;
    }

    protected void parse(String source) {
        while (source.length() > 0) {
            String name = source.substring(source.indexOf(nameTag) + nameLength, source.indexOf(bodyTag) + backspace);
            source = source.substring(source.indexOf(bodyTag));
            String body = source.substring(source.indexOf(bodyTag) + bodyLength, !source.contains(nameTag) ? source.length() : source.indexOf(nameTag) + backspace);
            source = !source.contains(nameTag) ? "" : source.substring(source.indexOf(nameTag));
            scripts.add(new ScriptContainer(name, body));
        }
    }
}
