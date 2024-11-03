package lotto;

import static lotto.NumberType.PURCHASE_UNIT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public void issueByAmount(int price) {
        int lottoQuantity = price / PURCHASE_UNIT;

        for (int i = 0; i < lottoQuantity; i++) {
            List<Integer> numbers = Utils.generateRandomNumbers();
            lottos.add(new Lotto(numbers));
        }
    }

    public int size() {
        return lottos.size();
    }

    public List<String> getAllLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .toList();
    }

    public Map<LottoRanking, Integer> compareWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoRanking, Integer> compareResult = new HashMap<>();

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchingNumbers(winningNumbers);
            boolean hasBonus = lotto.contains(bonusNumber);

            LottoRanking rank = LottoRanking.getRanking(matchCount, hasBonus);
            compareResult.put(rank, compareResult.getOrDefault(rank, 0) + 1);
        }
        return compareResult;
    }
}
