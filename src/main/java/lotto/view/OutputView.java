package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoGroup;
import lotto.domain.WinnerResult;
import lotto.domain.Winners;

public class OutputView {
    private static final String OUTPUT_BOUGHT_AMOUNT = "%d개를 구매했습니다.\n";
    private static final String OUTPUT_WINNING_STATICS = "당첨 통계";
    private static final String OUTPUT_LINE = "---";
    private static final String MATCHED_NUMBER = "%d개 일치 (%s원) - %d개\n";
    private static final String BONUS_MATCHED_NUMBER = "%d개 일치, 보너스 볼 일치 (%s원) - %d개\n";
    private static final String FINAL_RATE = "총 수익률은 %.1f%%입니다.";
    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";

    public void printBoughtAmount(int amount) {
        System.out.printf(OUTPUT_BOUGHT_AMOUNT, amount);
    }

    public void printLottoGroup(LottoGroup lottoGroup) {
        List<Lotto> lottos = lottoGroup.getLottoGroup();
        for (Lotto lotto : lottos) {
            printEachLotto(lotto);
        }
    }

    private void printEachLotto(Lotto lotto) {
        List<Integer> lottoNumbers = new ArrayList<>(lotto.getNumbers());
        Collections.sort(lottoNumbers);
        String result = lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX));
        System.out.println(result);
    }

}
