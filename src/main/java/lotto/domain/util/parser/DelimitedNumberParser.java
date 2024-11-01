package lotto.domain.util.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class DelimitedNumberParser implements StringParser<List<Integer>> {

    public final static String NUMBER_DELIMITER = ",";
    public final static int NUMBERS_LENGTH = 6;

    public static DelimitedNumberParser instance;

    private DelimitedNumberParser() {}

    public static DelimitedNumberParser getInstance() {
        if (instance == null) {
            instance = new DelimitedNumberParser();
        }
        return instance;
    }

    public List<Integer> parse(String input) {
        Set<String> collect = Arrays.stream(input.split(NUMBER_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toCollection(HashSet<String>::new));

        if (collect.size() != NUMBERS_LENGTH) {
            throw new IllegalArgumentException();
        }

        return parseIntList(collect);
    }

    private List<Integer> parseIntList(final Set<String> collect) {
        collect.forEach(this::validateNumeric);

        return List.copyOf(collect.stream()
                .map(Integer::parseInt)
                .toList());
    }

}
