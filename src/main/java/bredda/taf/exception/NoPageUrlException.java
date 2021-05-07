package bredda.taf.exception;

public class NoPageUrlException extends IllegalStateException {

    public NoPageUrlException(String page) {
        super(String.format("Tried to open page %s but no path specified", page));
    }

}
