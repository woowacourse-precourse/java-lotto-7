package lotto;

import static lotto.Inputor.getLottoDrawCount;
import static lotto.LottoGenerator.generateLottos;
import static lotto.OutputPrinter.printLotto;

import java.util.List;

public class LottoApplication {
    public static final int INCORRECT_LOTTO_DRAW_COUNT = -1;
    public void start(){

        int lottoDrawCount = INCORRECT_LOTTO_DRAW_COUNT;

        while(lottoDrawCount == INCORRECT_LOTTO_DRAW_COUNT) {
            lottoDrawCount = getLottoDrawCount();
        }

        List<Lotto> lottos = generateLottos(lottoDrawCount);
        printLotto(lottos);
    }


}
