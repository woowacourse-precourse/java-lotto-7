package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.message.LottoMessage;

import java.util.List;

public class LottoPrinter {

    private final OutputPort outputPort;

    public LottoPrinter(OutputPort outputPort) {
        this.outputPort = outputPort;
    }

    public void printLottoAmount(List<Lotto> lottos, LottoMessage lottoMessage) {
        outputPort.print(String.format("\n%d%s", lottos.size(), lottoMessage.getMessage()));
    }

    public void printLotto(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            outputPort.print(lotto.toString());
        }
    }

    public void printResult(Rank rank, int count) {
        outputPort.print(String.format("%s - %d개", rank.getDisplayMessage(), count));
    }

    public void printYield(double yield) {
        outputPort.print(String.format("총 수익률은 %.1f%%입니다.", yield));
    }

    public void printMessage(LottoMessage message) {
        outputPort.print(message.getMessage());
    }
}
