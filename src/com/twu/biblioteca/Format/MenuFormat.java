package Format;

public class MenuFormat {
    public static String format(String message) {
        return String.format("[ %c ] %s", message.charAt(0), message);
    }
}
