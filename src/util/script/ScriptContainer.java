package util.script;

public class ScriptContainer {
    private final String name;
    private final String body;
    public ScriptContainer(String name, String body) {
        this.name = name;
        this.body = body;
    }

    public String getName() {
        return name;
    }
    public String getBody() {
        return body;
    }
}
