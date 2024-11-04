package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class LottoService {
    private static final int PRICE = 1000;
    private static final String LOTTO_PRICE_MESSAGE = "[ERROR] 로또 구입 금액은 1000원 단위여야 합니다.";

    public List<Lotto> purchaseLottos(int amount) {
        validateAmount(amount);
        int count = amount / PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(generateLotto());
        }
        return lottos;
    }

    private void validateAmount(int amount) {
        if (amount % PRICE != 0) {
            throw new IllegalArgumentException(LOTTO_PRICE_MESSAGE);
        }
    }

    private Lotto generateLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public Map<LottoRank, Integer> checkWinning(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        Map<LottoRank, Integer> result = initializeResult();

        for (Lotto lotto : lottos) {
            LottoRank rank = calculateRank(lotto, winningNumbers, bonusNumber);
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    private Map<LottoRank, Integer> initializeResult() {
        Map<LottoRank, Integer> result = new HashMap<>();
        for (LottoRank rank : LottoRank.values()) {
            result.put(rank, 0);
        }
        return result;
    }

    private LottoRank calculateRank(Lotto lotto, Lotto winningNumbers, int bonusNumber) {
        int matchCount = lotto.matchCount(winningNumbers);
        boolean matchBonus = matchCount == 5 && lotto.containsNumber(bonusNumber);
        return LottoRank.valueOf(matchCount, matchBonus);
    }

    public double calculateReturnRate(Map<LottoRank, Integer> result, int purchaseAmount) {
        long totalPrize = calculateTotalPrize(result);
        return (totalPrize * 100.0) / purchaseAmount;
    }

    private long calculateTotalPrize(Map<LottoRank, Integer> result) {
        return result.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
