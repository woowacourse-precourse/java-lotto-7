package lotto.view;

public class OutputView {
    private static final String BUDGET_INPUT_DESC = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_INPUT_DESC = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_INPUT_DESC = "보너스 번호를 입력해 주세요.";
    public static void printBudgetInputDescription(){
        System.out.println(BUDGET_INPUT_DESC);
    }
    public static void printWinningNumberInputDescription(){
        System.out.println(WINNING_NUMBER_INPUT_DESC);
    }
    public static void printBonusNumberInputDescription(){
        System.out.println(BONUS_INPUT_DESC);
    }

}
