package lotto.view;

import java.util.List;

public interface Output {

    void printlnMessage(PrintMessage printMessage);

    void printBuyResult(Integer purchase);

    void printWinningDetail(List<String> winning);

    void printProfitRate(float profit);
}
