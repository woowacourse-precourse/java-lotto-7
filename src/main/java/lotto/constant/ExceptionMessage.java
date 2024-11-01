package lotto.constant;

public enum ExceptionMessage {
    LIST_OVER_MAX_LENGTH("list is over mat length.");

    private String message;

    private ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
