package lotto.validator.strategies;

public interface ValidationStrategy<T> {
    void validate(T input);
}
