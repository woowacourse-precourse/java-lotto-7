package lotto.io;

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

    private void println(String string) {
        System.out.println(string);
    }
}
