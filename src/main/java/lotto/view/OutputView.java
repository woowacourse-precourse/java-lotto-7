package lotto.view;

import java.util.List;

public class OutputView {
    private static final String NEW_LINE = "\n";
    private static final String BUDGET_INPUT_DESC = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_DESC = "\n당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_DESC = "\n보너스 번호를 입력해 주세요.";
    private static final String LOTTO_NUMBER_OUTPUT_DESC = "개를 구매했습니다.";
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

}
