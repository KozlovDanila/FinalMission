package utils;

public final class ValueUtils {

    public ValueUtils() {
    }

    public static boolean checkValueInt(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                if (ch < '0' || ch > '9') {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkValueDouble(String str) {
        return str.matches("\\d+\\.\\d+");
    }

}
