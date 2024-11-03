package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.constant.LottoConstants;
import lotto.exception.DuplicateBonusNumberException;
import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.LottoNumberNotInRangeException;
import lotto.validation.InputValidation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        lottoNumbersDuplicate(numbers);
    }

    private static void lottoNumbersDuplicate(List<Integer> numbers) {
        long distinctCount = numbers.stream().distinct().count();
        if (distinctCount < 6) {
            throw new DuplicateLottoNumberException();
        }
    }

    public void bonusNumberDuplicate(int bonusNumber) {
        long distinctCount = Stream.concat(numbers.stream(), Stream.of(bonusNumber))
                .distinct()
                .count();
        if (distinctCount != 7) {
            throw new DuplicateBonusNumberException();
        }
    }

    public static int getNumberIfInRange(final String lottoNumber) throws IllegalArgumentException {
        int lottoNum = InputValidation.parseNumberValidation(lottoNumber);
        Lotto.isLottoNumberOutOfRange(lottoNum);
        return lottoNum;
    }

    private static void isLottoNumberOutOfRange(int number) {
        if (number < 1 || number > 45) {
            throw new LottoNumberNotInRangeException();
        }
    }

    public int matchLottoCount(Lotto purchaseLotto) {
        int matchCount = (int) purchaseLotto.numbers.stream()
                .filter(numbers::contains)
                .count();
        return matchCount;
    }

    public boolean matchBonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return LottoConstants.OUTPUT_LOTTO_PREFIX + numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(LottoConstants.OUTPUT_LOTTO_DELIMITER))
                + LottoConstants.OUTPUT_LOTTO_SUFFIX;
    }
}
