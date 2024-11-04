package lotto.utils;

public enum ExceptionType {
    LIST_OVER_MAX_LENGTH("list is over mat length."),
    INVALID_NUMERIC_STRING("String is not numeric."),
    OUT_OF_RANGE_INT("stage is out of int type rage"),
    NON_POSITIVE_NUMBER("number is not positive number"),
    NON_DIVISIBLE("values are not divisible relation"),
    OUT_OF_SPECIFIC_RANGE("out of specific range"),

    //Number list  related
    NOT_PROPER_SIZE("list size is not proper"),

    //STRING related
    EMPTY_STRING("string is empty");

    private final String message;

    private ExceptionType(String message){
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }

}
