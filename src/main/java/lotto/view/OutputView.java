package lotto.view;

import static lotto.constants.OutputMessage.GET_TOTAL_LOTTO_COUNT_MESSAGE;
import static lotto.constants.OutputMessage.GET_WINNING_STATISTICS_MESSAGE;
import static lotto.constants.OutputMessage.LINE_SEPARATOR;
import static lotto.constants.OutputMessage.PERCENT_IS;
import static lotto.constants.OutputMessage.RETURN_ON_INVESTMENT_IS;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import lotto.dto.LottoNumbers;
import lotto.dto.LottoBundle;
import lotto.dto.LottoEvaluatedStatus;
import lotto.model.LottoPrize;
import lotto.model.LottoTicket;

public class OutputView {

    public void printError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printLottoTicketStatus(LottoTicket lottoTicket) {
        LottoBundle lottoTicketStatus = lottoTicket.getLottoBundle();
        int lottoCount = lottoTicketStatus.getLottoNumbers().size();

        printTotalLottoCount(lottoCount);
        printLottoTicketNumbers(lottoTicket);
    }

    public void printPrizeResult(LottoEvaluatedStatus lottoPrizeStatus) {
        printResultMessage();

        HashMap<LottoPrize, Integer> prizeStatus = lottoPrizeStatus.getPrizeStatus();
        double returnOnInvestment = lottoPrizeStatus.getReturnOnInvestment();

        printPrizeStatus(prizeStatus);
        printReturnOnInvestment(returnOnInvestment);
    }

    private void printTotalLottoCount(int totalTickets) {
        System.out.println(totalTickets + GET_TOTAL_LOTTO_COUNT_MESSAGE.getMessage());
    }

    private void printLottoTicketNumbers(LottoTicket lottoTicket) {
        LottoBundle lottoTicketStatus = lottoTicket.getLottoBundle();
        List<LottoNumbers> lottoNumbers = lottoTicketStatus.getLottoNumbers();

        for (LottoNumbers lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber.getLottoNumbers());
        }
    }

    private void printResultMessage() {
        System.out.println();
        System.out.println(GET_WINNING_STATISTICS_MESSAGE.getMessage());
        System.out.println(LINE_SEPARATOR.getMessage());
    }

    private void printPrizeStatus(HashMap<LottoPrize, Integer> prizeStatus) {
        LottoPrize[] prizes = LottoPrize.values();

        for (LottoPrize prize : prizes) {
            if (LottoPrize.FAIL == prize) {
                continue;
            }
            int prizeCount = prizeStatus.get(prize);
            System.out.println(prize.getPrizeStatusMessage(prizeCount));
        }
    }

    private void printReturnOnInvestment(double returnOnInvestment) {
        BigDecimal bigROI = new BigDecimal(returnOnInvestment);
        BigDecimal roi = bigROI.setScale(1, RoundingMode.HALF_UP);
        System.out.println(RETURN_ON_INVESTMENT_IS.getMessage() + roi + PERCENT_IS.getMessage());
    }
}
