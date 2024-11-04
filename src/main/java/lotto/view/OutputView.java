package lotto.view;

import lotto.domain.Lottos;

import static lotto.constant.PrizeMoney.*;
import static lotto.view.OutputMessage.*;

public class OutputView {

    public static void printPurchasePrice() {
        printMessage(PURCHASE_PRICE_MESSAGE.getMessage());
    }

    public static void printRequestPurchaseQuantity(Integer quantity) {
        printMessage(PURCHASE_QUANTITY_MESSAGE.formattedMessage(quantity));
    }

    public static void printLottos(Lottos lottos) {
        printMessage(PURCHASE_QUANTITY_MESSAGE.formattedMessage(lottos.getQuantity()));
        printMessage(lottos.toString());
    }

    public static void printRequestWinningNumber() {
        printMessage(WINNING_NUMBER_MESSAGE.getMessage());
    }

    public static void printRequestBonusNumber() {
        printMessage(BONUS_NUMBER_MESSAGE.getMessage());
    }

    public static void printTotalResult() {
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.printf("3개 일치 (%,d원) - %d개%n", FIFTH_PRIZE.getPrize(), FIFTH_PRIZE.getCount());
        System.out.printf("4개 일치 (%,d원) - %d개%n", FORTH_PRIZE.getPrize(), FORTH_PRIZE.getCount());
        System.out.printf("5개 일치 (%,d원) - %d개%n", THIRD_PRIZE.getPrize(), THIRD_PRIZE.getCount());
        System.out.printf("5개 일치, 보너스 볼 일치 (%,d원) - %d개%n", SECOND_PRIZE.getPrize(), SECOND_PRIZE.getCount());
        System.out.printf("6개 일치 (%,d원) - %d개%n", FIRST_PRIZE.getPrize(), FIRST_PRIZE.getCount());
    }

    public static void printYield(double yield) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", yield);
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }


}
