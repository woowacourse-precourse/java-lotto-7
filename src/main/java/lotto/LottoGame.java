package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGame {
    private static final int PRICE_PER_LOTTO = 1000;
    private final List<Lotto> purchasedLottos = new ArrayList<>();
    private final int purchaseAmount;
    private final Map<Rank, Integer> results = new HashMap<>();

    public LottoGame(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        generateLottos();
    }

    private void generateLottos() {
        int numberOfLottos = purchaseAmount / PRICE_PER_LOTTO;
        for (int i = 0; i < numberOfLottos; i++) {
            purchasedLottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }

    public void printPurchasedLottos() {
        System.out.println(purchasedLottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : purchasedLottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void calculateResults(WinNumbers winningNumbers, int bonusNumber) {
        for (Lotto lotto : purchasedLottos) {
            Rank rank = calculateRank(lotto, winningNumbers, bonusNumber);
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
    }

    private Rank calculateRank(Lotto lotto, WinNumbers winningNumbers, int bonusNumber) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (winningNumbers.getNumbers().contains(number)) {
                matchCount++;
            }
        }

        boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
        return Rank.of(matchCount, bonusMatch);
    }


}
