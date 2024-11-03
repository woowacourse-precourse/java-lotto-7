package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.message.PrintMessage;

public interface Output {

    void printlnMessage(PrintMessage printMessage);

    void printException(String exception);

    void printBuyResult(Integer purchase);

    void printLottoTicket(List<Lotto> lottoTicket);

    void printWinningDetail(List<String> winning);

    void printProfitRate(double profit);
}
