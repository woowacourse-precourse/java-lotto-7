package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final List<Lotto>lottoTickets=new ArrayList<>();
    private final Map<PrizeType, Integer> prizeStates = new EnumMap<>(PrizeType.class);

    public LottoGame(int purchaseAmount){
        for(int i=0;i<purchaseAmount/1000; i++){
            List<Integer> lottoNumbers=new ArrayList<>(Randoms.pickUniqueNumbersInRange(1,45,6));
            lottoTickets.add(new Lotto(lottoNumbers));
        }
        for (PrizeType prize : PrizeType.values()) {
            prizeStates.put(prize, 0);
        }
    }

    public List<Lotto>getLottoTickets(){
        return new ArrayList<>(lottoTickets);
    }
    public int getLottoCount(){
        return lottoTickets.size();
    }
    public void calculateLotto(List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottoTickets) {
            int matchCount = lotto.getMatchCount(winningNumbers);
            boolean hasBonusNumber = lotto.containsBonusNumber(bonusNumber);
            updatePrizeStates(matchCount, hasBonusNumber);
        }
    }

    private void updatePrizeStates(int matchCount, boolean hasBonusNumber) {
        for (PrizeType prize : PrizeType.values()) {
            if (prize.isWinner(matchCount, hasBonusNumber)) {
                prizeStates.put(prize, prizeStates.getOrDefault(prize, 0) + 1);
                break; // 첫 번째 일치하는 상금 유형을 찾으면 루프 종료
            }
        }
    }
    public Map<PrizeType, Integer> getPrizeStates(){
        return prizeStates;
    }

    public double calculateTotalProfitRate(Map<PrizeType, Integer>prizeStates, int purchaseAmount){
        double totalRevenue=prizeStates.entrySet().stream()
                .mapToDouble(entry->entry.getKey().getReward()* entry.getValue())
                .sum();
        return (totalRevenue/(double)purchaseAmount)*100;
    }
}