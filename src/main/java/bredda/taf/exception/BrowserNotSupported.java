package bredda.taf.exception;

public class BrowserNotSupported extends IllegalStateException {

    public BrowserNotSupported(String browser) {
        super(String.format("Browser %s not supported", browser));
    }
}