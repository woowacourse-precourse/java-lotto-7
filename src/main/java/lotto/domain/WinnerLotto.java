package lotto.domain;

import static lotto.utils.ErrorMessage.INVALID_WINNER_NUMBER;

import java.util.Arrays;
import java.util.List;

public class WinnerLotto {

    private static final String COMMA = ",";

    private final Lotto winLotto;
    private LottoNum bonusNum;

    protected WinnerLotto(String input) {
        valid(input);
        this.winLotto = parseToLotto(input);
        this.bonusNum = null;
    }

    public static WinnerLotto create(String input) {
        return new WinnerLotto(input);
    }

    public boolean hasBonusNum() {
        return this.bonusNum != null;
    }

    public WinnerCount countWinnerMatch(Lotto compareLotto) {
        int matchedCount = compareLotto.matchCount(this.winLotto);
        boolean hasBonusNum = compareLotto.hasNumber(this.bonusNum);

        return WinnerCount.of(matchedCount, hasBonusNum);
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
        List<LottoNum> winnerNums = Arrays.stream(splitNums).map(LottoNum::new).toList();

        return Lotto.create(winnerNums);
    }

    public void addBonusNum(LottoNum bonusNumber) {
        winLotto.validBonusNum(bonusNumber);
        this.bonusNum = bonusNumber;
    }

    @Override
    public String toString() {
        return winLotto.toString() + bonusNum.toString();
    }
}
