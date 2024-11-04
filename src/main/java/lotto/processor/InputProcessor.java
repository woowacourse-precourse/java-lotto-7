package lotto.processor;

@FunctionalInterface
public interface InputProcessor<T> {

    T process(String input);
}
