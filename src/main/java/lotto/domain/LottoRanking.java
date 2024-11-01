package lotto.domain;

import java.util.List;

public class LottoRanking {
    private static final int LOTTO_RANK_SIZE = 5;
    private final List<List<Integer>> myLottos;
    private final List<Integer> lotto;
    private final int bonusNumber;
    private final static int[] lottoRank = new int[LOTTO_RANK_SIZE];
    public LottoRanking(MyLotto myLottos, Lotto lotto, BonusNumber bonusNumber){
        this.myLottos = myLottos.getMyLottos();
        this.lotto = lotto.getNumbers();
        this.bonusNumber = bonusNumber.getBonus();
        checkMyLotto();
    }
    private void checkMyLotto(){
        for(List<Integer> myLotto:myLottos){
            int commonNumbersCount = countCommonNumbers(lotto, myLotto);
            checkMyRank(commonNumbersCount, myLotto);
        }
    }
    private void checkMyRank(int commonNumbersCount, List<Integer> myLotto) {
        Ranking rank = Ranking.findRank(commonNumbersCount, myLotto.contains(bonusNumber));
        if (rank == null){
            return ;
        }
        lottoRank[rank.getIndex()] += 1;
    }
    private int countCommonNumbers(List<Integer> lotto, List<Integer> myLotto) {
        return (int) lotto.stream()
                .filter(myLotto::contains)
                .count();
    }
    public int[] getLottoRank() {
        return lottoRank;
    }
}
