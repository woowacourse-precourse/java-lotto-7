package lotto.domain.lotto;

import java.util.Arrays;
import java.util.List;
import lotto.domain.lotto.dto.GetLottoDto;
import lotto.domain.lottoMachine.BonusNumber;
import lotto.domain.lottoMachine.WinningLotto;
import lotto.global.exception.Exception;
import lotto.global.exception.ValidatorBuilder;

public class Lotto {
    private static final String SPLIT_DELIMITER = ",";
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = validateLotto(numbers);
    }

    private List<Integer> validateLotto(List<Integer> inputNumbers) {
        return ValidatorBuilder.from(inputNumbers)
                .validate(numbers -> numbers.size() != LOTTO_SIZE, Exception.INVALID_LOTTO_SIZE)
                .validate(numbers -> numbers.size() != numbers.stream().distinct().count(),
                        Exception.DUPLICATE_LOTTO_NUMBER)
                .validate(numbers -> numbers.stream()
                                .anyMatch(number -> number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER),
                        Exception.INVALID_LOTTO_NUMBER)
                .get();
    }

    public static Lotto from(String numbers) {
        return new Lotto(parseNumbers(numbers));
    }
    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }


    private static List<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split(SPLIT_DELIMITER))
                .map(number -> ValidatorBuilder.from(number)
                        .validateIsInteger()
                        .getNumericValue())
                .toList();
    }

    public boolean isContains(BonusNumber bonusNumber) {
        return numbers.stream()
                .anyMatch(bonusNumber::isDuplicate);
    }

    public boolean isContains(int number) {
        return numbers.contains(number);

    }

    public GetLottoDto getLotto() {
        return new GetLottoDto(numbers);
    }

    public int getMatchCount(WinningLotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto::isContains)
                .count();
    }

}
