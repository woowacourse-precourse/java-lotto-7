package lotto.Service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.View.OutputView;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.RankResult;
import lotto.domain.UserLotto;

import java.util.*;

public class LottoService {
    private static int purchaseAmount=0;
    private static final int START_LOTTO_NUMBER=1;
    private static final int END_LOTTO_NUMBER=45;
    private static final int LOTTO_COUNT=6;
    private static final int LOTTO_PRICE=1000;

    public List<Lotto> purchaseLotto(int purchase_amount){
        purchaseAmount=purchase_amount;
        List<Lotto> lottos = new ArrayList<>();
        int lotto_count=LottoNumber(purchase_amount);
        OutputView.print_purchase_count(lotto_count);
        for(int i=0;i<lotto_count;i++){
            lottos.add(getGenerateLotto());
        }
        OutputView.print_lotto_list(lottos);
        return lottos;
    }
    public int LottoNumber(int purchase_amount){
        return purchase_amount/LOTTO_PRICE;
    }
    private Lotto getGenerateLotto(){
        List<Integer> lottoNumbers = new ArrayList<>();
        lottoNumbers=Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER, END_LOTTO_NUMBER, LOTTO_COUNT);
        return new Lotto(lottoNumbers);
    }
    public RankResult winning_statistics(List<Lotto> lottos,List<Integer> winning_numbers,int bonus_number){
        Map<Rank,Integer> rankResult=new EnumMap<>(Rank.class);
        for(Lotto lotto:lottos){
            int count=contain_Count(lotto.getNumbers(),winning_numbers);
            boolean is_bonus_number=lotto.check_Bonus_Number(bonus_number);
            Rank rank=Rank.check_Rank(count,is_bonus_number);
            if(rank!=null) rankResult.put(rank,rankResult.getOrDefault(rank,0)+1);
        }
        return new RankResult(rankResult);
    }
    private int contain_Count(List<Integer> lotto, List<Integer> winning_numbers){
        int count=0;
        for(Integer number:winning_numbers){
            if(lotto.contains(number)) count++;
        }
        return count;
    }
    public double profit_rate(RankResult rankResult) {
        Map<Rank, Integer> rank_Result = rankResult.getRank_Count();
        double sum = 0;
        for (Rank rank : rank_Result.keySet()) {
            sum += rank.getPrice() * rank_Result.get(rank);
        }
        double profit_rate = (sum / purchaseAmount) * 100;
        return Math.round(profit_rate * 100.0) / 100.0;
    }
}
