package org.campus02.textanalysis;

public class IllegalTextAnalysisFormatException extends Exception {

    public IllegalTextAnalysisFormatException() {
    }

    public IllegalTextAnalysisFormatException(String message) {
        super(message);
    }

    public IllegalTextAnalysisFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalTextAnalysisFormatException(Throwable cause) {
        super(cause);
    }

    public IllegalTextAnalysisFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
