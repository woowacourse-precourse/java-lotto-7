package lotto.Domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import lotto.Enum.LottoRange;

public class LottoNumber {
    private final List<Integer> numbers;
    private final int bonusNumber;

    public LottoNumber() {
        List<Integer> generatedNumbers = generateNumbers();
        this.numbers = new ArrayList<>(generatedNumbers.subList(0, 6));
        this.bonusNumber = generatedNumbers.get(6);
    }

    private List<Integer> generateNumbers() {
        return new Random()
                .ints(LottoRange.LOTTO_LOWEST_NUMBER.getValue(),
                        LottoRange.LOTTO_HIGHEST_NUMBER.getValue())
                .distinct()
                .limit(7)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}

