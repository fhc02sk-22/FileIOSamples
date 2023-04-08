package org.campus02.addressbook;

import java.io.FileNotFoundException;

public class AddressExportException extends Exception {

    public AddressExportException() {
    }

    public AddressExportException(String message) {
        super(message);
    }

    public AddressExportException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddressExportException(Throwable cause) {
        super(cause);
    }

    public AddressExportException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
