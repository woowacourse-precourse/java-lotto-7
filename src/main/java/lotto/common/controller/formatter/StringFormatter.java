package lotto.common.controller.formatter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.lotto.domain.LottoResult;
import lotto.lotto.domain.LottoResults;
import lotto.lotto.domain.value.LottoRank;
import lotto.purchase.domain.PurchaseResult;

public class StringFormatter {

    private static final DecimalFormat RATE_FORMAT = new DecimalFormat("0.0");
    private static final Long DEFAULT_LOTTO_COUNT = 0L;
    private static final String LOTTO_INFORMATION_FORMAT = "%s (%s) - %d개";


    public String lottoNumberFormatter(LottoResults lottoResults) {
        List<LottoResult> lottos = lottoResults.getResults();
        StringBuilder sb = new StringBuilder();
        lottos.forEach(lottoResult -> sb.append(numberFormatter(lottoResult.getLotto().getNumbers())).append("\n"));
        return sb.toString();
    }

    public String lottoWinningInfoFormatter(PurchaseResult purchaseResult) {
        StringBuilder sb = new StringBuilder();
        Map<LottoRank, Long> winningInfo = purchaseResult.getWinningInfo();

        for (LottoRank rank : LottoRank.values()) {
            if (rank.equals(LottoRank.FAIL)) {
                continue;
            }
            sb.append(winningInfoFormatter(rank, winningInfo.getOrDefault(rank, DEFAULT_LOTTO_COUNT))).append("\n");
        }
        return sb.toString();
    }

    public String rateInfoFormatter(PurchaseResult purchaseResult) {
        BigDecimal rate = BigDecimal.valueOf(purchaseResult.getRateOfReturn()).setScale(1, RoundingMode.HALF_UP);
        return "총 수익률은 " + RATE_FORMAT.format(rate) + "%입니다." + "\n";
    }

    private String winningInfoFormatter(LottoRank rank, long count) {
        return String.format(LOTTO_INFORMATION_FORMAT, rank.getConditionMessage(), rank.getValueMessage(), count);
    }

    private String numberFormatter(List<Integer> lottoNumber) {
        return lottoNumber.stream().map(String::valueOf).collect(Collectors.joining(", ", "[", "]"));
    }


}
