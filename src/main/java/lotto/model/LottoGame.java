package lotto.model;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> purchasedLotto = new ArrayList<>();

    public List<Lotto> generateLotto(int quantity) {
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            purchasedLotto.add(new Lotto(numbers));
        }
        return purchasedLotto;
    }

    public LottoStatistics checkResults(List<Lotto> purchasedLotto, List<Integer> usersLotto, int bonusNumber) {
        LottoStatistics statistics = new LottoStatistics();

        for (Lotto lotto : purchasedLotto) {
            int matchCount = countMatchingNumbers(lotto.getNumbers(), usersLotto);
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            if (matchCount == 6) {
                statistics.increment("6개 일치 (2,000,000,000원)");
            } else if (matchCount == 5 && bonusMatch) {
                statistics.increment("5개 일치, 보너스 볼 일치 (30,000,000원)");
            } else if (matchCount == 5) {
                statistics.increment("5개 일치 (1,500,000원)");
            } else if (matchCount == 4) {
                statistics.increment("4개 일치 (50,000원)");
            } else if (matchCount == 3) {
                statistics.increment("3개 일치 (5,000원)");
            }
        }

        return statistics;
    }

    private int countMatchingNumbers(List<Integer> eachPurchasedLotto, List<Integer> usersLotto) {
        int count = 0;
        for (Integer number : eachPurchasedLotto) {
            if (usersLotto.contains(number)) {
                count++;
            }
        }
        return count;
    }
}