package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private Map<LottoRank, Integer> lottoResult;

    public WinningResult(final Lottos lottos, final WinningNumbersCombinations winningCombinations) {
        this.lottoResult = new EnumMap<>(LottoRank.class);
        initializeWinningResult();
        generateLottoResult(lottos, winningCombinations);
    }

    private void initializeWinningResult() {
        Arrays.stream(LottoRank.values())
                .forEach(winning -> lottoResult.put(winning, 0));
    }

    private void generateLottoResult(final Lottos lottos, final WinningNumbersCombinations winningCombinations) {
        for (Lotto lotto : lottos.getLottos()) {
            LottoRank lottoRank = LottoRank.findLottoRank(
                    winningCombinations.compareWinningNumbers(lotto),
                    winningCombinations.compareBonusNumber(lotto)
            );
            countLottoRank(lottoRank);
        }
    }

    private void countLottoRank(final LottoRank lottoRank) {
        lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, 0) + 1);
    }

    public long calculateProfit() {
        long sum = 0;
        for (LottoRank result : lottoResult.keySet()) {
            sum += result.getPrice() * lottoResult.get(result);
        }
        return sum;
    }

    public String displayWinningResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (LottoRank lottoRank : LottoRank.values()) {
            stringBuilder.append(String.format(lottoRank.getPrintMessages(),
                    lottoResult.get(lottoRank)));
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
