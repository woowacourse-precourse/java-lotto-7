package lotto.viewHandler.validator;

public interface Validator<T1, T2> {
    T1 validate(T2 input);
}
