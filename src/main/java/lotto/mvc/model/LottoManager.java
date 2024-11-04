package lotto.mvc.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.EnumMap;
import java.util.List;

public class LottoManager {
    private static final int LOTTO_PRICE_UNIT = 1000;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;
    private static final int COUNT_OF_LOTTO_NUMBER = 6;
    private LottoList lottoes;
    private WinningLotto winningLotto;

    public LottoManager() {
        this.lottoes = new LottoList();
    }

    public int extractLottoCount(long input) {
        Long count = input / LOTTO_PRICE_UNIT;
        return count.intValue();
    }

    public void makeLottoes(int count) {
        for (int i = 1; i <= count; i++) {
            lottoes.addLotto(makeLotto());
        }
    }

    private static Lotto makeLotto() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER,
                COUNT_OF_LOTTO_NUMBER);
        return new Lotto(lottoNumbers);
    }

    public LottoList getLottoes() {
        return lottoes;
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }

    public void setWinningLotto(List<Integer> lottoNumbers) {
        winningLotto = new WinningLotto(lottoNumbers);
    }

    public void setBonusNumber(int bonusNumber) {
        winningLotto.setBonus(bonusNumber);
    }

    public EnumMap<LottoWinningAmount, Integer> checkLottoWinning() {
        EnumMap<LottoWinningAmount, Integer> winningResults = new EnumMap<>(LottoWinningAmount.class);

        for (Lotto lotto : lottoes.getBunchofLottoes()) {
            int matchCount = getMatchCount(lotto);
            boolean matchBonus = isMatchBonus(lotto, matchCount, winningLotto.getBonus());

            recordResult(matchCount, matchBonus, winningResults);
        }

        return winningResults;
    }

    private int getMatchCount(Lotto lotto) {
        int count = 0;

        for (Integer number : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(number)) {
                count++;
            }
        }
        return count;
    }

    private boolean isMatchBonus(Lotto lotto, int matchCount, int bonus) {
        if (matchCount == 5 && lotto.getNumbers().contains(bonus)) {
            return true;
        }

        return false;
    }

    private void recordResult(int matchCount, boolean matchBonus,
                              EnumMap<LottoWinningAmount, Integer> winningResults) {
        for (LottoWinningAmount amount : LottoWinningAmount.values()) {
            if (findEqualResult(amount, matchCount, matchBonus)) {
                winningResults.put(amount, winningResults.getOrDefault(amount, 0) + 1);
                return;
            }
        }
    }

    private boolean findEqualResult(LottoWinningAmount amount, int matchCount, boolean matchBonus) {
        return matchCount == amount.getCount() && matchBonus == amount.isBonus();
    }
}
