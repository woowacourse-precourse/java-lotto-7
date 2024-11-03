package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;

public class LottoManager {

    private int amount;
    private Lotto winningLotto;
    private int bonus;
    private HashMap<LottoRank, Integer> winningResult;

    public void setWinningLotto(List<Integer> numbers, int bonus) {
        this.winningLotto = new Lotto(numbers);
        this.bonus = bonus;
    }

    public ArrayList<Lotto> purchaseLotto(int amount) {
        validateAmount(amount);
        this.amount = amount;
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


    public HashMap<LottoRank, Integer> getWinningResult(ArrayList<Lotto> lottos) {
        winningResult = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            winningResult.put(lottoRank, 0);
        }

        for (Lotto lotto : lottos) {
            int count = 0;
            boolean bonusMatch = false;
            for (int i : lotto.getNumbers()) {
                if (winningLotto.getNumbers().contains(i)) {
                    count++;
                }
                if (bonus == i) {
                    bonusMatch = true;
                }
            }

            if (count == 3) {
                winningResult.put(LottoRank.FIFTH,
                    winningResult.getOrDefault(LottoRank.FIFTH, 0) + 1);
            } else if (count == 4) {
                winningResult.put(LottoRank.FOURTH,
                    winningResult.getOrDefault(LottoRank.FOURTH, 0) + 1);
            } else if (count == 5 && bonusMatch) {
                winningResult.put(LottoRank.SECOND,
                    winningResult.getOrDefault(LottoRank.SECOND, 0) + 1);
            } else if (count == 5) {
                winningResult.put(LottoRank.THIRD,
                    winningResult.getOrDefault(LottoRank.THIRD, 0) + 1);
            } else if (count == 6) {
                winningResult.put(LottoRank.FIRST,
                    winningResult.getOrDefault(LottoRank.FIRST, 0) + 1);
            }
        }

        return winningResult;
    }


    public double getProfitRate() {
        double profitRate;
        double totalPrize = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            totalPrize += winningResult.get(lottoRank) * lottoRank.getPrize();
        }

        profitRate = Math.round(totalPrize / amount * 10000) / 100.0;
        return profitRate;
    }

    private void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000으로 나누어 떨어져야 합니다.");
        }
    }
}
