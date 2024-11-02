package lotto.io;

import static lotto.global.constant.Message.PURCHASE_INPUT_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;

public class OutputView {
    public void printLottos(List<Lotto> lottos) {
        String LottosToString = lottos.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
        println(LottosToString);
    }

    public void printPurchaseInputMessage() {
        println(PURCHASE_INPUT_MESSAGE);
    }
}
