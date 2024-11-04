package lotto.view;

import java.text.NumberFormat;
import java.util.stream.Collectors;
import lotto.model.Analyst;
import lotto.model.Lotties;
import lotto.model.Lotto;

public class OutputView {
    private static String INPUT_MONEY_PROMPT = "구입금액을 입력해 주세요.";
    private static String LOTTO_COUNTS_PROMPT = "개를 구매했습니다.";
    private static String INPUT_WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    private static String INPUT_BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static String WINNING_STATICS_PROMPT = "당첨통계\n---";
    private static String[] WINNING_STATICS_FORMAT = new String[]{"3개 일치", "4개 일치", "5개 일치", "5개 일치, 보너스 볼 일치", "6개 일치"};

    private NumberFormat numberFormat = NumberFormat.getInstance();

    public void printInputMoneyPrompt() {
        System.out.println(INPUT_MONEY_PROMPT);
    }

    public void printBoughtLottoCounts(int lottoCounts) {
        System.out.println(lottoCounts + LOTTO_COUNTS_PROMPT);
    }


    public void printBoughtLottoNumbers(Lotties lotties) {
        for (Lotto lotto : lotties.getLotties()) {
            System.out.println(lotto.getLottoNumbers().stream()
                    .sorted()
                    .map(Object::toString)
                    .collect(Collectors.joining(", ","[","]")));
        }
        System.out.println();
    }

    public void printInputWinningNumbersPrompt() {
        System.out.println(INPUT_WINNING_NUMBERS_PROMPT);
    }

    public void printInputBonusNumbersPrompt() {
        System.out.println(INPUT_BONUS_NUMBER_PROMPT);
    }

    public void printWinningStatics(Analyst analyst) {
        System.out.println(WINNING_STATICS_PROMPT);
        for (int i = 0; i < 5; i++) {
            System.out.printf("%s (%s원) - %d개\n",
                    WINNING_STATICS_FORMAT[i], numberFormat.format(analyst.winningsMoney()[i]), analyst.getWinLottos()[5-i]);
        }
        System.out.printf("총 수익률은 %s입니다.", analyst.getYield());
    }
}
