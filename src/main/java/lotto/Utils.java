package lotto;

import lotto.model.BonusNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static List<Integer> parseToList(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(BonusNumber::validateNumber)
                .collect(Collectors.toList());
    }
}
