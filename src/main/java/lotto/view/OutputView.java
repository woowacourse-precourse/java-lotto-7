package lotto.view;

import lotto.model.Lotto;
import lotto.model.Prize;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String OUTPUT_FORMAT_OF_LOTTO_COUNT = "\n%d개를 구매했습니다.\n";
    private static final String EMPTY_STRING = "";
    private static final String OUTPUT_FORMAT_OF_LOTTO = "%s\n";
    private static final String STATICS_MESSAGE = "\n당첨 통계\n---";
    private static final String OUTPUT_FORMAT_OF_STATICS = "%s - %d개\n";
    private static final String OUTPUT_FORMAT_OF_PROFIT_RATE = "총 수익률은 %.1f%%입니다.\n";
    private static final int FIFTH_RANK = 5;
    private static final int FIRST_RANK = 1;

    public void printLottoGroup(List<Lotto> purchasedLotto) {
        System.out.printf(OUTPUT_FORMAT_OF_LOTTO_COUNT, purchasedLotto.size());

        String result = EMPTY_STRING;
        for (int i = 0; i < purchasedLotto.size(); i++) {
            result += String.format(OUTPUT_FORMAT_OF_LOTTO, purchasedLotto.get(i).toString());
        }
        System.out.println(result);
    }

    public void printStatics(Map<Integer, Integer> prizeResult) {
        System.out.println(STATICS_MESSAGE);

        String result = EMPTY_STRING;
        for (int i = FIFTH_RANK; i >= FIRST_RANK; i--) {
            Prize prize = Prize.findPrizeByRank(i);
            int count = 0;
            if(prizeResult.containsKey(i)){
                count = prizeResult.get(i);
            }
            result += String.format(OUTPUT_FORMAT_OF_STATICS, prize.toString(), count);
        }
        System.out.print(result);
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(OUTPUT_FORMAT_OF_PROFIT_RATE, profitRate);
    }
}
