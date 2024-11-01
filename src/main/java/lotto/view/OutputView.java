package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    static final private String PURCHASE_AMOUNT_PROMPT = "구입금액을 입력해 주세요.";
    static final private String PURCHASE_CONFIRMATION_MESSAGE = "개를 구매했습니다.";
    static final private String WINNING_NUMBERS_PROMPT = "당첨 번호를 입력해 주세요.";
    static final private String BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";

    public OutputView() {
    }

    public void printPurchaseAmountRequest() {
        System.out.println(PURCHASE_AMOUNT_PROMPT);
    }

    public void printNumOfTickets(int numOfTickets) {
        System.out.println();
        System.out.println(numOfTickets + PURCHASE_CONFIRMATION_MESSAGE);
    }

    public void printGeneratedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printWinningNumbersRequest() {
        System.out.println();
        System.out.println(WINNING_NUMBERS_PROMPT);
    }

    public void printBonusNumberRequest() {
        System.out.println();
        System.out.println(BONUS_NUMBER_PROMPT);
    }

    public void printResult(String rankResult, String profitRateResult) {
        StringBuilder result = new StringBuilder();
        result.append("\n" + "당첨 통계\n" + "---\n")
                .append(rankResult)
                .append(profitRateResult);

        System.out.print(result);
    }
}
