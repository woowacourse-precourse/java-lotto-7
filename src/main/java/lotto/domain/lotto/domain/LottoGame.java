package lotto.domain.lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto.dto.response.LottoResultRes;
import lotto.domain.lotto.util.LottoConverter;

public class LottoGame {

    private final List<Lotto> purchasedLottos;
    private final List<LottoNumber> winningLottos;
    private final LottoNumber bonusNumber;
    private final int cost;
    private final Map<LottoResultRes, Integer> results;

    public LottoGame(
            List<Lotto> purchasedLottos,
            List<LottoNumber> winningLottos,
            LottoNumber bonusNumber,
            int cost
    ) {
        this.purchasedLottos = purchasedLottos;
        this.winningLottos = winningLottos;
        this.bonusNumber = bonusNumber;
        this.cost = cost;
        this.results = new HashMap<>();
    }

    public static LottoGame of(
            final List<List<Integer>> purchasedNumbers,
            final List<Integer> winningNumbers,
            final int bonusNumber,
            final int cost
    ) {
        return new LottoGame(
                LottoConverter.convertToLottos(purchasedNumbers),
                LottoConverter.convertToLottoNumbers(winningNumbers),
                LottoNumber.from(bonusNumber),
                cost
        );
    }

    /**
     * 로또 게임의 결과를 계산합니다.
     * 각 로또 번호와 당첨 번호를 비교하여 당첨 결과를 저장합니다.
     */
    public void calculateResults() {
        for (Lotto lotto : purchasedLottos) {
            LottoResultRes result = calculateResult(lotto);
            updateResult(result);
        }
    }

    private LottoResultRes calculateResult(Lotto lotto) {
        int matchCount = countMatchNumbers(lotto);
        boolean matchBonus = checkBonusNumber(lotto);
        return LottoResultRes.of(matchCount, matchBonus);
    }

    private int countMatchNumbers(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLottos::contains)
                .count();
    }

    private boolean checkBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    private void updateResult(LottoResultRes result) {
        results.put(result, results.getOrDefault(result, 0) + 1);
    }

    public Map<LottoResultRes, Integer> getResults() {
        return Collections.unmodifiableMap(results);
    }

    public int getCost() {
        return cost;
    }
}
