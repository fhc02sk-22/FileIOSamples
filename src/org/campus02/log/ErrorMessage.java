package org.campus02.log;

public class ErrorMessage {

    private String errorLevel;
    private String errorMessage;
    private String errorTime;

    public ErrorMessage(String errorLevel, String errorMessage, String errorTime) {

        switch (errorLevel) {
            case "INFO":
            case "DEBUG":
            case "ERROR":
            case "FATAL":
                this.errorLevel = errorLevel;
                break;
            default:
                System.out.println("Falscher ErrorLevel: " + errorLevel);
                this.errorLevel = "INFO";
        }

        this.errorMessage = errorMessage;
        this.errorTime = errorTime;
    }

    public String toLine(){
        return errorTime + ": " + errorLevel + " - " + errorMessage;
    }

    public String getErrorLevel() {
        return errorLevel;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorTime() {
        return errorTime;
    }
}
