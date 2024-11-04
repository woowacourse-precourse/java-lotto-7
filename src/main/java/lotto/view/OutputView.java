package lotto.view;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import lotto.dto.BuyLottosDTO;
import lotto.model.LottoResult;
import lotto.model.Prize;

public class OutputView {
    public static final OutputView INSTANCE = new OutputView();
    public static final String OUTPUT_LOTTO_MESSAGE = "개를 구매했습니다.";
    public static final String OUTPUT_PROFIT_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public void printLotto(int quantity) {
        System.out.println(quantity + OUTPUT_LOTTO_MESSAGE);
    }

    public void printLottoDetail(BuyLottosDTO buyLottos) {
        buyLottos.buyLottos().stream().forEach(buyLottoDTO -> System.out.println(buyLottoDTO.numbers()));
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("---");

        Map<Prize, Integer> statics = getStatics(lottoResult);
        statics.forEach((prize, count) ->
                printResult(PrintFormat.getFormat(prize.isBonusNumberRequired()),
                        prize.getConditionOfMatchCount(), prize.getMoney(), count)
        );
    }

    private Map<Prize, Integer> getStatics(LottoResult lottoResult) {
        Map<Prize, Integer> statics = Arrays.stream(Prize.values())
                .filter(prize -> !prize.equals(Prize.NO_PRIZE))
                .collect(toMap(prize -> prize, prize -> 0, (a, b) -> b, LinkedHashMap::new));

        for (Prize myPrize : lottoResult.getResult()) {
            statics.computeIfPresent(myPrize, (key, value) -> value + 1);
        }
        return statics;
    }

    private void printResult(String format, int numberOfMatch, long money, int count) {
        System.out.printf(format, numberOfMatch, money, count);
    }

    public void printProfitRate(double profitRate) {
        System.out.printf(OUTPUT_PROFIT_MESSAGE, profitRate);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printNewLine() {
        System.out.println();
    }
}
