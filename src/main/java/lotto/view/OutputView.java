package lotto.view;

import lotto.domain.LottoPaper;

public class OutputView {

    public static void printPaymentMessage() {
        System.out.println(OutputMessages.PAYMENT.getMessage());
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printLottoPaperMessage(LottoPaper lottoPaper){
        int lottoCount = lottoPaper.getLottoCount();
        System.out.println();
        System.out.println(OutputMessages.PURCHASED_LOTTO_COUNT.getFormattedMessage(lottoCount));
        lottoPaper.getLottoNumbers().forEach(System.out::println);
    }

}