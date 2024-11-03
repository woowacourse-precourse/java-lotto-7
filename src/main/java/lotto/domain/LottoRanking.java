package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRanking {
    private static final int LOTTO_RANK_SIZE = 5;
    private static final int SECOND_OR_THIRD = 5;
    private final List<List<Integer>> myLottos;
    private final List<Integer> lotto;
    private final int bonusNumber;
    private final static List<Integer> lottoRanking = new ArrayList<>(Collections.nCopies(LOTTO_RANK_SIZE, 0));
    public LottoRanking(MyLotto myLottos, Lotto lotto, BonusNumber bonusNumber){
        this.myLottos = myLottos.getMyLottos();
        this.lotto = lotto.getNumbers();
        this.bonusNumber = bonusNumber.getBonus();
        getLottoRank();
    }
    private void getLottoRank(){
        for(List<Integer> myLotto:myLottos){
            int commonNumbersCount = countCommonNumbers(lotto, myLotto);
            countLottoRank(commonNumbersCount, myLotto);
        }
    }
    private void countLottoRank(int commonNumbersCount, List<Integer> myLotto) {
        Ranking rank = matchLottoRank(commonNumbersCount, myLotto);
        if (rank == null){
            return ;
        }
        int value = lottoRanking.get(rank.getIndex());
        lottoRanking.set(rank.getIndex(), value+1);
    }
    private Ranking matchLottoRank(int commonNumbersCount, List<Integer> myLotto){
        if(commonNumbersCount == SECOND_OR_THIRD){
            return Ranking.findRank(commonNumbersCount, myLotto.contains(bonusNumber));
        }
        return Ranking.findRank(commonNumbersCount, false);
    }
    private int countCommonNumbers(List<Integer> lotto, List<Integer> myLotto) {
        return (int) lotto.stream()
                .filter(myLotto::contains)
                .count();
    }
    public List<Integer> getLottoRanking() {
        return lottoRanking;
    }
}
