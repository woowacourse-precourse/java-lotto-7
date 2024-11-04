package lotto.constant;

public enum ExceptionMessage {
    LIST_OVER_MAX_LENGTH("list is over mat length."),
    INVALID_NUMERIC_STRING("String is not numeric."),
    OUT_OF_RANGE_INT("stage is out of int type rage"),
    NON_POSITIVE_NUMBER("number is not positive number"),

    //STRING related
    EMPTY_STRING("string is empty");


    static final String OUTPUT_MESSAGE_HEAD = "[ERROR] ";
    private String message;

    private ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

    private void printExceptionMessage(){
        String outputMessage = ExceptionMessage.OUTPUT_MESSAGE_HEAD + this.getMessage();
        System.out.println(outputMessage);
    }

    public void throwIllegalArgumentException() throws IllegalArgumentException{
        this.printExceptionMessage();
        throw new IllegalArgumentException( this.getMessage());
    }
}
