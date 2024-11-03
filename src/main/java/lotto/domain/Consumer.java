package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;

import static lotto.validation.Validation.*;

public class Consumer {

    private final static int MAX_COST = 100000;
    private final static int MIN_COST = 1000;
    private final static int ZERO = 0;
    private final static int ONE = 1;
    private final static int MATCH_NUMBERS_FIVE = 5;
    private final ArrayList<Lotto> lottoes = new ArrayList<>();
    private final HashMap<LottoRank, Integer> lottoRankResult = new HashMap<>();
    private final int money;

    public Consumer(int money) {
        validateMoney(money);
        this.money = money;
        initLottoRank();
    }

    private void validateMoney(int money) {
        checkMoneyMinCost(money, MIN_COST);
        checkMoneyMaxCost(money, MAX_COST);
    }

    public int getMoney() {
        return money;
    }


    public void buyLotto(Lotto lotto) {
        lottoes.add(lotto);
    }

    public ArrayList<Lotto> getLottoes() {
        return lottoes;
    }

    public void initLottoRank() {
        for (LottoRank rank : LottoRank.values()) {
            lottoRankResult.put(rank, ZERO);
        }
    }

    public void updateLottoRank(int matchNumbers, boolean bonusMatch) {
        for (LottoRank rank : LottoRank.values()) {
            updateRanking(matchNumbers, bonusMatch, rank);
        }
    }

    private void updateRanking(int matchNumbers, boolean bonusMatch, LottoRank rank) {

        bonusInclude(matchNumbers, bonusMatch, rank);

        if (rank.getCount() == matchNumbers) {
            lottoRankResult.put(rank, lottoRankResult.get(rank) + ONE);
        }
    }

    private void bonusInclude(int matchNumbers, boolean bonusMatch, LottoRank rank) {
        if (matchNumbers == MATCH_NUMBERS_FIVE) {
            if (rank.getCount() == matchNumbers && rank.getBonus() == bonusMatch) {
                lottoRankResult.put(rank, lottoRankResult.get(rank) + ONE);
            }
        }
    }

    public HashMap<LottoRank, Integer> getLottoRankResult() {
        return lottoRankResult;
    }

}
