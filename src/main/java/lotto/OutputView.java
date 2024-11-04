package lotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static final String LOTTO_AMOUNT_PROMPT = "구입 금액을 입력해 주세요.";
    public static final String LOTTO_WINNING_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
    public static final String LOTTO_BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    public static final String CONFIRM_PURCHASE_TEXT = "개를 구매했습니다.";

    public void printLottoAmountPrompt() {
        System.out.println(LOTTO_AMOUNT_PROMPT);
    }

    public void printLottoWinningNumberPrompt() {
        System.out.println(LOTTO_WINNING_NUMBER_PROMPT);
    }

    public void printLottoBonusNumberPrompt() {
        System.out.println();
        System.out.println(LOTTO_BONUS_NUMBER_PROMPT);
    }

    public void printLottoAmount(int lottoAmount) {
        System.out.println();
        System.out.println(lottoAmount + CONFIRM_PURCHASE_TEXT);
    }

    public void printUserLottoNumber(List<List<Integer>> userLottoNumbers) {
        for (List<Integer> userLottoNumber : userLottoNumbers) {
            System.out.println(userLottoNumber);
        }
        System.out.println();
    }

    public void printLottoResult(Map<Rank, Integer> lottoPrizeCount) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : lottoPrizeCount.keySet()) {
            System.out.println(rank.getWinningMessage() + " - " + lottoPrizeCount.get(rank) + "개");
        }
    }

    public void printLottoProfit(double lottoProfit) {
        System.out.println("총 수익률은 " + String.format("%.1f", lottoProfit) + "%입니다.");
    }
}
