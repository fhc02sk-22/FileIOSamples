package org.campus02.addressbook;


public class AddressLoadException extends Exception {
    public AddressLoadException() {
    }

    public AddressLoadException(String message) {
        super(message);
    }

    public AddressLoadException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressLoadException(Throwable cause) {
        super(cause);
    }

    public AddressLoadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
