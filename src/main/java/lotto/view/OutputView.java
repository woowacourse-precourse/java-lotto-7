package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.dto.LottoDto;
import lotto.service.WinningResult;

import java.util.List;
import java.util.Map;

public class OutputView {

    private static final String PURCHASE_QUANTITY = "개를 구매했습니다.";
    private static final String WINNING_RESULT = "\n당첨 통계\n---\n";
    private static final String TOTAL_RATE = "총 수익률은 %.1f";
    private static final String PERCENTAGE = "%입니다.";

    public void printPurchaseAmount(final int amount) {
        System.out.println(amount + PURCHASE_QUANTITY);
    }

    public void printPurchasedLottos(final List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        List<LottoDto> sortedLotto = sortLottos(lottos);
        for (LottoDto lotto : sortedLotto) {
            sb.append(lotto).append('\n');
        }
        System.out.println(sb);
    }

    public void printLottoResults(final LottoResult lottoResult) {
        StringBuilder sb = new StringBuilder();
        sb.append(WINNING_RESULT);

        for (Map.Entry<WinningResult, Integer> entry : lottoResult.getResults().entrySet()) {
            String s = entry.getKey().makeSentence(entry.getValue());
            sb.append(s).append('\n');
        }
        System.out.print(sb);
    }

    public void printTotalRate(final double rate) {
        String format = String.format(TOTAL_RATE, rate);
        System.out.print(format + PERCENTAGE);
    }

    private List<LottoDto> sortLottos(final List<Lotto> lottos) {
        return lottos.stream().map(LottoDto::new).toList();
    }

}
