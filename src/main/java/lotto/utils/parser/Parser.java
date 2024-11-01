package lotto.utils.parser;

public interface Parser<Type> {
    Type parse(String value);
}
