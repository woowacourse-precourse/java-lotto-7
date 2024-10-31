package lotto.view;

import java.util.List;

public class OutputView implements Output {

    @Override
    public void printlnMessage(PrintMessage printMessage) {
        System.out.println(printMessage.getMessage());
    }

    @Override
    public void printPurchaseResult(Integer purchase) {
        System.out.printf(PrintMessage.LOTTO_PURCHASE_NUMBER.getMessage(), purchase);
    }

    @Override
    public void printWinningDetail(List<String> winning) {
        winning.forEach(System.out::println);
    }

    @Override
    public void printProfitRate(float profit) {
        System.out.printf(PrintMessage.LOTTO_PROFIT_RATE.getMessage(), profit);
    }
}
