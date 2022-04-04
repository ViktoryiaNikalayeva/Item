package utils;

import java.util.List;
import java.util.Random;

public class EnumUtils {

    private static final List<HighDomain> VALUES = List.of(HighDomain.values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();


    public static HighDomain getValue() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public static String randomString() {
        return getValue().getHd();
    }
}
