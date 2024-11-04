package lotto.domain.util.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.exception.DelimitedNumberFormatException;

public final class DelimitedNumberParser implements StringParser<List<Integer>> {

    public final static String NUMBER_DELIMITER = ",";

    public static DelimitedNumberParser instance;

    private DelimitedNumberParser() {}

    public static DelimitedNumberParser getInstance() {
        if (instance == null) {
            instance = new DelimitedNumberParser();
        }
        return instance;
    }

    @Override
    public List<Integer> parse(String input) {
        Set<String> collect = Arrays.stream(input.split(NUMBER_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toCollection(HashSet<String>::new));

        validate(collect);
        return parseIntList(collect);
    }

    private List<Integer> parseIntList(final Set<String> collect) {
        return List.copyOf(collect.stream()
                .map(Integer::parseInt)
                .toList());
    }

    private void validate(final Set<String> collect) {
        for (String s : collect) {
            if (isNotNumeric(s)) {
                throw DelimitedNumberFormatException.invalidNumber();
            }
        }
    }

}
