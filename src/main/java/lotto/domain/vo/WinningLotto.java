package lotto.domain.vo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.entity.Lotto;

public record WinningLotto(Lotto lotto, BonusNumber bonus) {
    private static final String SEPARATOR = ",";

    private WinningLotto(List<Integer> numbers, BonusNumber bonus) {
        this(new Lotto(numbers), bonus);
    }

    public static WinningLotto of(String inputNumbers, String inputBonus) {
        List<Integer> numbers = parseInputNumbers(inputNumbers);
        return new WinningLotto(numbers, new BonusNumber(inputBonus));
    }

    private static List<Integer> parseInputNumbers(String input) {
        String[] splitInput = input.trim().split(SEPARATOR);
        return Arrays.stream(splitInput)
            .map(String::trim)
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }

}
