package Format;

import Menu.Option.Option;

public class MenuFormat {
    public static String format(Option option) {
        return String.format("[ %c ] %s", option.getKey().toUpperCase().charAt(0), option.getName());
    }
}
