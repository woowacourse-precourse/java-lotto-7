package lotto.model;

import static lotto.utils.LottoConfig.FIVE_MATCHES_PRIZE;
import static lotto.utils.LottoConfig.FIVE_MATCHES_WITH_BONUS_PRIZE;
import static lotto.utils.LottoConfig.FOUR_MATCHES_PRIZE;
import static lotto.utils.LottoConfig.LOTTO_PRICE;
import static lotto.utils.LottoConfig.SIX_MATCHES_PRIZE;
import static lotto.utils.LottoConfig.THREE_MATCHES_PRIZE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProfitCalculator {

    public static final Integer Three=3;
    public static final Integer Four=4;
    public static final Integer Five=5;
    public static final Integer FiveBonus=7;
    public static final Integer Six=6;

    public Map<Integer, Integer> calculateMatches(List<Lotto> lottos, Lotto win, int bonusNum){
        Map<Integer, Integer> matches = matchesInit();
        boolean gotBonus;

        for(Lotto lotto : lottos){
            gotBonus=lotto.getNumbers().contains(bonusNum);
            calculateMatch(matches,lotto.getNumbers(),win.getNumbers(),gotBonus);
        }
        return matches;
    }

    public float calculateProfit(Map<Integer,Integer> matches, int purchaseNum){
        float profit = 0;
        profit += matches.get(Three)*THREE_MATCHES_PRIZE.getValue();
        profit += matches.get(Four)*FOUR_MATCHES_PRIZE.getValue();
        profit += matches.get(Five)*FIVE_MATCHES_PRIZE.getValue();
        profit += matches.get(FiveBonus)*FIVE_MATCHES_WITH_BONUS_PRIZE.getValue();
        profit += matches.get(Six)*SIX_MATCHES_PRIZE.getValue();
        profit = 100 * profit / (purchaseNum * LOTTO_PRICE.getValue());

        return profit;
    }

    private Map<Integer,Integer> matchesInit(){
        Map<Integer,Integer> matches = new HashMap<>();
        matches.put(Three,0);
        matches.put(Four,0);
        matches.put(Five,0);
        matches.put(FiveBonus,0);
        matches.put(Six,0);
        return matches;
    }

    private void calculateMatch(Map<Integer, Integer> matches, List<Integer> list1, List<Integer> list2, boolean gotBonus){
        int lottoMatchNum = getMatchNum(list1,list2);

        if(gotBonus){
            lottoMatchNum++;
        }
        if(gotBonus && lottoMatchNum==Five){
            matches.put(FiveBonus,matches.get(FiveBonus)+1);
            return;
        }
        if(lottoMatchNum>=Three) {
            matches.put(lottoMatchNum, matches.get(lottoMatchNum) + 1);
        }
    }

    private int getMatchNum(List<Integer> list1, List<Integer> list2){
        Set<Integer> set1 = new HashSet<>(list1);
        Set<Integer> set2 = new HashSet<>(list2);
        set1.retainAll(set2);
        return set1.size();
    }
}
