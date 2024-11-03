package lotto;

import java.util.*;

public class LottoResult {

    private static final List<LottoRank> printOrder = Arrays.asList(LottoRank.RANK_5, LottoRank.RANK_4, LottoRank.RANK_3, LottoRank.RANK_2, LottoRank.RANK_1);
    private List<Lotto> lottos;
    private WinningLotto winningLotto;

    public LottoResult(List<Lotto> lottos, WinningLotto winningLotto){
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public void printResult(){
        Map<LottoRank, Integer> result = getResult();
        long sumPrize = 0;
        for(LottoRank rank : printOrder){
            int size = result.getOrDefault(rank,0);
            System.out.println(rank.toString()+" - "+size+"개");
            sumPrize += rank.getPrize() * size;
        }
        System.out.println("총 수익률은 "+String.format("%.1f", calculateYield(sumPrize))+"%입니다.");
    }

    public Map<LottoRank, Integer> getResult(){
        Map<LottoRank, Integer> result = new EnumMap<>(LottoRank.class);
        for(Lotto lotto : lottos){
            LottoRank rank = LottoRank.getLottoRank(lotto, winningLotto);
            if(rank == null) continue;
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    public double calculateYield(long sumPrize){
        sumPrize *= 100;
        int buyPrize = Lotto.PRICE * lottos.size();

        return (double) sumPrize / buyPrize;
    }

}
