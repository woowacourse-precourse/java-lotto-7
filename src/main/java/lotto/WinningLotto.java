package lotto;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {

    private Lotto winningLotto;
    private int bonusNumber;

    private static final String INVALID_LOTTO_RANGE_MESSAGE = "1부터 45 사이의 숫자를 입력해야 합니다";
    private static final String DUPLICATE_BONUS_NUMBER_MESSAGE = "당첨번호와 중복됩니다.";
    private static final int BONUS_NUMBER_MIN = 1;
    private static final int BONUS_NUMBER_MAX = 45;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        if (bonusNumber < BONUS_NUMBER_MIN || bonusNumber >= BONUS_NUMBER_MAX) {
            throw new IllegalArgumentException(INVALID_LOTTO_RANGE_MESSAGE);
        }

        if (winningLotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_MESSAGE);
        }
    }

    public Map<LottoPrize, Integer> getWinningResult(List<Lotto> playerLottos) {
        Map<LottoPrize, Integer> winningResult = initResult();
        for (Lotto playerLotto : playerLottos) {
            long matchCount = playerLotto.countMatchingNumbersBy(winningLotto);
            boolean hasBonusNumber = playerLotto.hasNumber(bonusNumber);
            LottoPrize lottoPrize = LottoPrize.findLottoPrizeBy(matchCount, hasBonusNumber);
            winningResult.put(lottoPrize, winningResult.get(lottoPrize) + 1);
        }
        return winningResult;
    }

    private Map<LottoPrize, Integer> initResult() {
        Map<LottoPrize, Integer> winningResult = new EnumMap<>(LottoPrize.class);
        for (LottoPrize prize : LottoPrize.values()) {
            winningResult.put(prize, 0);
        }
        return winningResult;
    }
}
