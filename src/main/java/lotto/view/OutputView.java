package lotto.view;

import lotto.domain.LottoPaper;

public class OutputView {

    public static void printPaymentMessage() {
        System.out.println(OutputMessage.PAYMENT.getMessage());
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printLottoPaperMessage(LottoPaper lottoPaper){
        int lottoCount = lottoPaper.getLottoCount();
        System.out.println();
        System.out.println(OutputMessage.PURCHASED_LOTTO_COUNT.getFormattedMessage(lottoCount));
        lottoPaper.getLottoNumbers().forEach(System.out::println);
    }

    public static void printWinningLottoMessage() {
        System.out.println();
        System.out.println(OutputMessage.WINNING_LOTTO.getFormattedMessage());
    }

    public static void printBonusNumberMessage() {
        System.out.println();
        System.out.println(OutputMessage.BONUS_NUMBER.getFormattedMessage());
    }
}