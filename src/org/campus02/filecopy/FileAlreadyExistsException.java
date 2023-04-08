package org.campus02.filecopy;

public class FileAlreadyExistsException extends Exception {

    public FileAlreadyExistsException() {
    }

    public FileAlreadyExistsException(String message) {
        super(message);
    }

    public FileAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public FileAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
