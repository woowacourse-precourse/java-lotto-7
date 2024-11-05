package lotto.generator;

public interface Generator <T, R> {

    R generate(T t);
}
