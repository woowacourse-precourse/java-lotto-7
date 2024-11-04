package lotto.view;

import java.text.NumberFormat;
import lotto.domain.LottoPaper;
import lotto.domain.enums.LottoPrize;
import lotto.domain.enums.LottoRank;

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

    public static void printLottoResultMessagePrefix(){
        System.out.println();
        System.out.println(OutputMessage.RESULT_PREFIX.getMessage());
        System.out.println(OutputMessage.DOTTED_LINE.getMessage());
    }

    public static void printLottoResultMessage(LottoRank rank, int resultCount) {
        String bonusMessage = getBonusMessage(rank);
        String formattedPrize = formatPrize(LottoPrize.fromRank(rank).getPrize());
        String resultMessage = OutputMessage.RANK.getFormattedMessage(
                rank.getMatchCount(),
                bonusMessage,
                formattedPrize);
        resultMessage += OutputMessage.RANK_COUNT.getFormattedMessage(resultCount);
        
        System.out.println(resultMessage);
    }


    private static String getBonusMessage(LottoRank rank) {
        if(rank.getMatchCount()==5 && rank.isMatchBonus()){
            return OutputMessage.BONUS.getMessage();
        }
        return "";
    }

    private static String formatPrize(int prize) {
        return NumberFormat.getInstance().format(prize);
    }

    public static void printTotalRateMessage(double returnRate){
        System.out.println();
        System.out.println(OutputMessage.RATIO.getFormattedMessage(returnRate));
    }
}