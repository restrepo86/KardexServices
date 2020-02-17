package co.com.todo.uno.kardex.util;

public final class Utils {

    private Utils() {
        super();
    }

    public static boolean isEmptyLong(Long longData) {
        return longData == null || longData.longValue() == 0;
    }

}
