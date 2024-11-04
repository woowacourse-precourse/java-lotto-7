package lotto.domain.calculator;

public interface Calculator<T,R> {
    R calculate(T calculatedValue);
}
