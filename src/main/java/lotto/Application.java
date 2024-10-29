package lotto;

import lotto.io.LottoRequestReader;
import lotto.io.LottoResponseWriter;

public class Application {
    public static void main(String[] args) {
        LottoFactory lottoFactory = new LottoFactory();
        LottoWinningEvaluator lottoWinningEvaluator = new LottoWinningEvaluator();
        LottoMachine lottoMachine = new LottoMachine(lottoWinningEvaluator, lottoFactory);

        LottoPrice lottoPrice = new LottoPrice();
        LottoRequestReader lottoRequestReader = new LottoRequestReader();
        LottoResponseWriter lottoResponseWriter = new LottoResponseWriter();

        LottoManager lottoManager = new LottoManager(lottoRequestReader, lottoResponseWriter, lottoMachine, lottoPrice);
        lottoManager.run();
    }
}
