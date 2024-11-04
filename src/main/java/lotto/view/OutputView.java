package lotto.view;

import lotto.model.LottoRank;
import lotto.model.Lottos;
import lotto.model.LottosResult;

public class OutputView {
    private static final String NEXT_LINE = "\n";
    private static final String COUNT = "개";
    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_MESSAGE = "당첨 통계" + NEXT_LINE + "---";
    private static final String QUANTITY_MESSAGE_FORMAT = "%d개를 구매했습니다.";
    private static final String RATE_OF_RETURN_MESSAGE_FORMAT = "총 수익률은 %.1f%%입니다.";

    public void printPurchaseAmountMessage() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printQuantity(int quantity) {
        System.out.printf(QUANTITY_MESSAGE_FORMAT, quantity);
        nextLine();
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public void printWinningNumbersMessage() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
    }

    public void printBonusNumberMessage() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
    }

    public void showLottosResult(LottosResult lottosResult) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        for (LottoRank lottoRank : LottoRank.getAllLottoRank(false)) {
            System.out.println(lottoRank.getDescription() + lottosResult.get(lottoRank) + COUNT);
        }
        System.out.printf(RATE_OF_RETURN_MESSAGE_FORMAT, lottosResult.getRateOfReturn());
        nextLine();
    }

    public void nextLine() {
        System.out.println();
    }
}
