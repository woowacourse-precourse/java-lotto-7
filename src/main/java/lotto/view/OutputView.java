package lotto.view;

import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String BUDGET_INPUT_DESC = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_DESC = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_DESC = "\n보너스 번호를 입력해 주세요.";
    private static final String LOTTO_NUMBER_OUTPUT_DESC = "개를 구매했습니다.";
    private static final String LOTTO_RESULT_OUTPUT_DESC = "\n당첨 통계\n---";

    public static void printBudgetInputDescription(){
        System.out.println(BUDGET_INPUT_DESC);
    }
    public static void printWinningNumberInputDescription(){
        System.out.println(WINNING_NUMBER_INPUT_DESC);
    }
    public static void printBonusNumberInputDescription(){
        System.out.println(BONUS_INPUT_DESC);
    }
    public static void printLottoNumber(int lottoNumber){
        System.out.println(NEW_LINE+lottoNumber+LOTTO_NUMBER_OUTPUT_DESC);
    }
    public static void printLotto(List<Integer> lotto) {
        System.out.println(lotto);
    }
    public static void printResultDescription(){
        System.out.println(LOTTO_RESULT_OUTPUT_DESC);
    }
    public static void printEachRank(String message, int money, Integer count) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        String str = message
                + String.format("(%s원)", formatter.format(money))
                + String.format(" - %s개", count);
        System.out.println(str);
    }
    public static void printProfitRate(double profitRate) {
        DecimalFormat formatter = new DecimalFormat("###,###.0");
        System.out.printf("총 수익률은 %s%%입니다.%n", formatter.format(profitRate));
    }

}
