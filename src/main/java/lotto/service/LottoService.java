package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoService {

    final int LOTTO_PRICE = 1000;

    public List<Lotto> purchaseLotto(int purchaseAmount){
        if(purchaseAmount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위이어야 합니다.");
        }
        int purchaseLottoCount = purchaseAmount / LOTTO_PRICE;
        return issueLotto(purchaseLottoCount);
    }

    public Map<Rank, Integer> calculateResult(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        Map<Rank, Integer> result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatches(winningNumber);
            boolean isBonusMatched = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.getRank(matchCount, isBonusMatched);
            result.put(rank, result.get(rank) + 1);
        }

        return result;
    }


    public double calculateProfitRate(Map<Rank, Integer> result, int investmentMoney) {
        int totalProfit = 0;

        for (Map.Entry<Rank, Integer> entry : result.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalProfit += rank.getPrize() * count;
        }
        return ((double) totalProfit / investmentMoney) * 100;
    }


    private List<Lotto> issueLotto(int purchaseLottoCount){
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<purchaseLottoCount; i++){
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

}
