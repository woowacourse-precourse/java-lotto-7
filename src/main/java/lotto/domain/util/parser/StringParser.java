package lotto.domain.util.parser;

public interface StringParser<R> {

    R parse(String input);

    default boolean isNotNumeric(String s) {
        return !s.chars().allMatch(Character::isDigit);
    }

}
