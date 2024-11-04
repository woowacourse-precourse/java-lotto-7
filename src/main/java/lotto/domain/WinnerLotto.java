package lotto.domain;

import static lotto.utils.ErrorMessage.INVALID_WINNER_NUMBER;
import static lotto.utils.ErrorMessage.NOT_HAVE_BONUS_NUM;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import lotto.utils.Reward;

public class WinnerLotto {

    private static final String COMMA = ",";

    private final Lotto winLotto;
    private LottoNumber bonusNumber;

    protected WinnerLotto(String input) {
        validInput(input);
        this.winLotto = parseToLotto(input);
        this.bonusNumber = null;
    }

    public static WinnerLotto create(String input) {
        return new WinnerLotto(input);
    }

    public void validBonusNumber() {
        if (this.bonusNumber == null) {
            throw new IllegalStateException(NOT_HAVE_BONUS_NUM.getMessage());
        }
    }

    public Reward countWinnerMatch(Lotto compareLotto) {
        validBonusNumber();
        int matchedCount = compareLotto.matchCount(this.winLotto);
        boolean hasBonusNumber = compareLotto.hasNumber(this.bonusNumber);

        return Reward.forMatch(matchedCount, hasBonusNumber);
    }


    private void validInput(String input) {
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
