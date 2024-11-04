package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private final List<Lotto> purchasedLottos;

    public LottoGame(){
        this.purchasedLottos = new ArrayList<>();
    }

    public void buyLottos(int purchaseNum){
        for(int i = 0; i < purchaseNum; i++){
            List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6)); // 불변 리스트를 ArrayList로 복사
            Collections.sort(lottoNumbers);
            purchasedLottos.add(new Lotto(lottoNumbers));
        }
    }

    public void calculateResults(List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : purchasedLottos) {
            int matchCount = lotto.countMatchNum(winningNumbers);
            boolean bonusMatch = lotto.containBonusNum(bonusNumber);
            Prize prize = Prize.getPrize(matchCount, bonusMatch);
            if (prize != null) {
                prize.incrementCount();
            }
        }
    }

    public double calculateProfit(int totalPrice) {
        int totalPrizeMoney = Arrays.stream(Prize.values())
                .mapToInt(prize -> prize.getPrizeMoney() * prize.getCount())
                .sum();
        return ((double) totalPrizeMoney / totalPrice) * 100;
    }

    public List<List<Integer>> getPurchasedLottos() {
        return purchasedLottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }
}
