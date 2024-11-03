package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;
import lotto.LottoPrize;

public class LottoManager {

    public Lotto getWinningLotto(List<Integer> numbers, int bonus) {
        Lotto lotto = new Lotto(numbers);
        lotto.setBonusNumber(bonus);
        return lotto;
    }


    public ArrayList<Lotto> purchaseLotto(int amount) {
        validateAmount(amount);
        ArrayList<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount / 1000; i++) {
            lottos.add(drawLotto());
        }

        return lottos;
    }


    public Lotto drawLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        return new Lotto(numbers);
    }


    public HashMap<LottoPrize, Integer> getWinningResult(ArrayList<Lotto> lottos,
        Lotto winningLotto) {
        HashMap<LottoPrize, Integer> winningResult = new HashMap<>();
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            winningResult.put(lottoPrize, 0);
        }

        for (Lotto lotto : lottos) {
            int count = getMatchCount(lotto, winningLotto);
            boolean bonusMatch = getBonusMatch(lotto, winningLotto);
            plusWinningCount(winningResult, count, bonusMatch);
        }
        return winningResult;
    }


    private int getMatchCount(Lotto lotto, Lotto winningLotto) {
        int count = 0;
        for (int i : lotto.getNumbers()) {
            if (winningLotto.getNumbers().contains(i)) {
                count++;
            }
        }
        return count;
    }


    private boolean getBonusMatch(Lotto lotto, Lotto winningLotto) {
        boolean bonusMatch = false;

        for (int i : lotto.getNumbers()) {
            if (winningLotto.getBonusNumber() == i) {
                return true;
            }
        }
        return false;
    }


    private void plusWinningCount(HashMap<LottoPrize, Integer> winningResult, int count,
        boolean bonusMatch) {
        if (count == 3) {
            winningResult.put(LottoPrize.FIFTH,
                winningResult.getOrDefault(LottoPrize.FIFTH, 0) + 1);
        } else if (count == 4) {
            winningResult.put(LottoPrize.FOURTH,
                winningResult.getOrDefault(LottoPrize.FOURTH, 0) + 1);
        } else if (count == 5 && bonusMatch) {
            winningResult.put(LottoPrize.SECOND,
                winningResult.getOrDefault(LottoPrize.SECOND, 0) + 1);
        } else if (count == 5) {
            winningResult.put(LottoPrize.THIRD,
                winningResult.getOrDefault(LottoPrize.THIRD, 0) + 1);
        } else if (count == 6) {
            winningResult.put(LottoPrize.FIRST,
                winningResult.getOrDefault(LottoPrize.FIRST, 0) + 1);
        }
    }


    public double getProfitRate(HashMap<LottoPrize, Integer> winningResult, int purchaseAmount) {
        double profitRate;
        double totalPrize = 0;
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            totalPrize += winningResult.get(lottoPrize) * lottoPrize.getPrize();
        }

        profitRate = Math.round(totalPrize / purchaseAmount * 10000) / 100.0;
        return profitRate;
    }


    private void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000으로 나누어 떨어져야 합니다.");
        }
    }
}
