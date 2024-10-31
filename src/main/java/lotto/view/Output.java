package lotto.view;

import java.util.List;

public interface Output {

    void printlnMessage(PrintMessage printMessage);

    void printPurchaseResult(Integer purchase);

    void printWinningDetail(List<String> winning);

    void printProfitRate(float profit);
}
