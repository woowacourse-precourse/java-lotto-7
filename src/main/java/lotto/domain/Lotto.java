package lotto.domain;

import lotto.constants.Ranking;
import lotto.validator.LottoValidator;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        LottoValidator.validateLotto(numbers);
        List<LottoNumber> lottoNumbers = convertToLottoNumbers(numbers);
        return new Lotto(lottoNumbers);
    }

    private static List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    public Ranking checkRanking(WinningLotto winLotto) {
        int matchCount = calculateMatchCount(winLotto.getLotto().getNumbers());
        boolean isBonusMatch = isMatchBonusNumber(winLotto.getBonusNumber());
        return Ranking.of(matchCount, isBonusMatch);
    }

    private int calculateMatchCount(List<LottoNumber> winNumbers) {
        return (int) winNumbers.stream()
                .filter(numbers::contains)
                .count();
    }

    private boolean isMatchBonusNumber(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    public List<Integer> getNumberValues() {
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }
}
