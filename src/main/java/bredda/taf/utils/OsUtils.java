package bredda.taf.utils;

public class OsUtils {

    public static String getOsName() {
        return System.getProperty("os.name").toLowerCase();
    }

    public static boolean isWindows() {
        return (getOsName().contains("win"));
    }
    public static boolean isMac() {
        return (getOsName().contains("mac"));
    }
    public static boolean isUnix() {
        return (getOsName().contains("nix")
                || getOsName().contains("nux")
                || getOsName().contains("aix"));
    }

}
