package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final List<Lotto> lottos = new ArrayList<>();
    private Map<String, Integer> winnings = new HashMap<>();

    public void BuyLotto (int amount) {
        if (amount % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,0000원 단위여야 합니다.");
        }

        int quantity = amount / 1000;
        for (int i = 0; i < quantity; i++){
            List <Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        System.out.println(quantity+ "개를 구매했습니다.");
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void UpdateWinnings (List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();

            if (matchCount == 6) {
                winnings.put("6개 일치", winnings.getOrDefault("6개 일치", 0) + 1);
            }
            if (matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
                winnings.put("5개 일치, 보너스 볼 일치", winnings.getOrDefault("5개 일치, 보너스볼 일치", 0) + 1);
            }
            if (matchCount == 4) {
                winnings.put("4개 일치", winnings.getOrDefault("4개 일치", 0) + 1);
            }
            if (matchCount == 3) {
                winnings.put("3개 일치", winnings.getOrDefault("3개 일치", 0) + 1);
            }
        }
    }
}
