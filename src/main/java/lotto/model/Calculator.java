package lotto.model;

public abstract class Calculator {
    Double divide(Integer divided, Integer dividend) {
        return (double) ((double) divided / dividend);
    }
}
