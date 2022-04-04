package utils;

import org.apache.commons.lang.RandomStringUtils;


public class RandomUtils {

    public static String createEmailPasswordAndDomain() {
        return RandomStringUtils.random(48, DataSettingsUtils.getElement("characters"));
    }
}



