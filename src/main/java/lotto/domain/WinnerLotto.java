package lotto.domain;

import static lotto.utils.ErrorMessage.INVALID_WINNER_NUMBER;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WinnerLotto {

    private static final String COMMA = ",";

    private final Lotto winLotto;
    private LottoNumber bonusNumber;

    protected WinnerLotto(String input) {
        valid(input);
        this.winLotto = parseToLotto(input);
        this.bonusNumber = null;
    }

    public static WinnerLotto create(String input) {
        return new WinnerLotto(input);
    }

    public boolean hasBonusNumber() {
        return this.bonusNumber != null;
    }

    public CountResult countWinnerMatch(Lotto compareLotto) {
        int matchedCount = compareLotto.matchCount(this.winLotto);
        boolean hasBonusNumber = compareLotto.hasNumber(this.bonusNumber);

        return CountResult.of(matchedCount, hasBonusNumber);
    }


    private void valid(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(INVALID_WINNER_NUMBER.getMessage());
        }

        boolean startsWith = input.startsWith(COMMA);
        boolean endsWith = input.endsWith(COMMA);

        if (startsWith || endsWith) {
            throw new IllegalArgumentException(INVALID_WINNER_NUMBER.getMessage());
        }
    }

    private Lotto parseToLotto(String input) {
        String[] splitNums = input.split(COMMA);
        List<LottoNumber> winnerNums = Arrays.stream(splitNums)
                .map(LottoNumber::new)
                .toList();

        return Lotto.create(winnerNums);
    }

    public void addBonusNumber(LottoNumber bonusNumber) {
        winLotto.validBonusNum(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinnerLotto that = (WinnerLotto) o;
        return Objects.equals(winLotto, that.winLotto) && Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winLotto, bonusNumber);
    }
}
