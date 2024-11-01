package lotto;

import static lotto.constant.ExtraText.NEW_LINE;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public String printLottosNumbers() {
        StringBuilder lottosNumbers = new StringBuilder();
        for (Lotto lotto : lottos) {
            lottosNumbers.append(lotto.printLottoNumbers());
            lottosNumbers.append(NEW_LINE.getText());
        }
        return lottosNumbers.toString();
    }
}
