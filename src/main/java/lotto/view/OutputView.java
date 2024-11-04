package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.message.PrintMessage;

public class OutputView implements Output {

    @Override
    public void printlnMessage(PrintMessage printMessage) {
        System.out.println(printMessage.getMessage());
    }

    @Override
    public void printException(String exception) {
        System.out.println(exception);
    }

    @Override
    public void printBuyResult(Integer purchase) {
        System.out.printf(PrintMessage.LOTTO_PURCHASE_NUMBER.getMessage(), purchase);
    }

    @Override
    public void printLottoTicket(List<Lotto> lottoTicket) {
        lottoTicket.stream()
                .map(lotto -> lotto.getNumbers().toString())
                .forEach(System.out::println);
    }

    @Override
    public void printWinningDetail(List<String> winning) {
        winning.forEach(System.out::println);
    }

    @Override
    public void printProfitRate(double profit) {
        System.out.printf(PrintMessage.LOTTO_PROFIT_RATE.getMessage(), profit);
    }
}
