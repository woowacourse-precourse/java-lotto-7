package lotto.validator;

public interface Validator {
    public void validate();

    default void printErrorMessageAndThrowError(String message){
        System.out.println(message);
        throw new IllegalArgumentException(message);
    }
}
