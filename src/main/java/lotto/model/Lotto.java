package lotto.model;

import java.util.Collections;
import java.util.List;
import lotto.util.LottoNumberGenerator;
import lotto.vo.BonusNumber;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLottoNumber(numbers);
        this.numbers = numbers;
    }

    public static Lotto createWinningLotto(final List<Integer> winningNumbers) {
        return new Lotto(winningNumbers);
    }

    public static Lotto createLottoNumber(final LottoNumberGenerator lottoNumberGenerator) {
        return new Lotto(createNumbersWithGenerator(lottoNumberGenerator));
    }

    private static List<Integer> createNumbersWithGenerator(final LottoNumberGenerator lottoNumberGenerator) {
        List<Integer> randomNumbers = lottoNumberGenerator.numberGenerator();
        return Collections.unmodifiableList(randomNumbers);
    }

    private void validateLottoNumber(List<Integer> numbers) {

    }

    public int countMatchedNumbers(final Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::contain)
                .count();
    }

    public boolean checkBonusNumberContain(final BonusNumber bonusNumber) {
        return this.contain(bonusNumber.number());
    }

    private boolean contain(final Integer number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
