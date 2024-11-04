package lotto;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningLotto {

    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber >= 45) {
            throw new IllegalArgumentException("1부터 45 사이의 숫자를 입력해야 합니다");
        }

        if (winningLotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException("당첨번호와 중복됩니다.");
        }
    }

    public Map<LottoPrize, Integer> getWinningResult(List<Lotto> playerLottos) {
        Map<LottoPrize, Integer> winningResult = initResult();
        List<Integer> winningNumbers = winningLotto.getNumbers();
        for (Lotto playerLotto : playerLottos) {
            List<Integer> numbers = playerLotto.getNumbers();
            long matchCount = numbers.stream().filter(winningNumbers::contains).count();
            boolean hasBonusNumber = numbers.contains(bonusNumber);
            LottoPrize lottoPrize = LottoPrize.findLottoPrizeBy(matchCount, hasBonusNumber);
            winningResult.put(lottoPrize, winningResult.get(lottoPrize) + 1);
        }
        return winningResult;
    }

    private Map<LottoPrize, Integer> initResult() {
        Map<LottoPrize, Integer> winningResult = new EnumMap<>(LottoPrize.class);
        for(LottoPrize prize : LottoPrize.values()) {
            winningResult.put(prize, 0);
        }
        return winningResult;
    }

}
