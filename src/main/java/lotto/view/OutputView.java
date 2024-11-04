package lotto.view;

import static lotto.global.Message.BUY_LOTTO_COUNT_MESSAGE;
import static lotto.global.Message.LOTTO_BONUS_NUMBER_CORRECT_RESULT;
import static lotto.global.Message.LOTTO_NUMBER_CORRECT_RESULT;
import static lotto.global.Message.LOTTO_NUMBER_RESULT;
import static lotto.global.Message.LOTTO_PROFIT_RESULT;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.global.LottoScore;

public class OutputView {

    public void printTotalLottoCounts(int lottoCounts) {
        System.out.println("\n" + lottoCounts + BUY_LOTTO_COUNT_MESSAGE.getMsg());
    }

    public void printLottoRandomNumber(List<Lotto> randomLotto) {
        randomLotto.stream().map(Lotto::getNumbers).forEach(System.out::println);
    }

    public void printLottoResult(Map<LottoScore, Integer> lottoResult) {
        System.out.println(LOTTO_NUMBER_RESULT.getMsg());

        lottoResult.forEach((lottoScore, count) -> {
            String matchCountMessage = generateMatchCountMessage(lottoScore, count);
            System.out.println(matchCountMessage);
        });
    }

    public void printLottoProfit(double lottoProfit) {
        String format = String.format(LOTTO_PROFIT_RESULT.getMsg(), lottoProfit);
        System.out.println(format);
    }

    private String generateMatchCountMessage(LottoScore lottoScore, int count) {
        String matchPattern;

        if (lottoScore.isCorrectBonusNumber()) {
            matchPattern = LOTTO_BONUS_NUMBER_CORRECT_RESULT.getMsg();
        } else {
            matchPattern = LOTTO_NUMBER_CORRECT_RESULT.getMsg();
        }

        return String.format(matchPattern, lottoScore.getCorrectLottoNumberCounts(), lottoScore.getWinningMoney(),
                count);
    }
}