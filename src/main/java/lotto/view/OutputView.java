package lotto.view;

import java.text.NumberFormat;

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
}
