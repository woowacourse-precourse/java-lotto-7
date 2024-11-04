package lotto.domain.util.parser;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.domain.exception.DelimitedNumberFormatException;
import lotto.domain.util.LottoNumberGenerator;

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

        validateCount(collect);
        validateNumeric(collect);
        List<Integer> parsed = parseIntList(collect);
        validateRange(parsed);

        return parsed;
    }

    private List<Integer> parseIntList(final Set<String> collect) {
        return List.copyOf(collect.stream()
                .map(Integer::parseInt)
                .toList());
    }

    private void validateCount(final Set<String> collect) {
        if (collect.size() != LottoNumberGenerator.LOTTO_NUMBERS_SIZE) {
            throw DelimitedNumberFormatException.invalidCount();
        }
    }

    private void validateRange(final List<Integer> collect) {
        for (Integer i : collect) {
            if (i <= LottoNumberGenerator.MIN_LOTTO_NUMBER || i > LottoNumberGenerator.MAX_LOTTO_NUMBER) {
                throw DelimitedNumberFormatException.outOfRange();
            }
        }
    }

    private void validateNumeric(final Set<String> collect) {
        for (String s : collect) {
            if (isNotNumeric(s)) {
                throw DelimitedNumberFormatException.invalidNumber();
            }
        }
    }

}
