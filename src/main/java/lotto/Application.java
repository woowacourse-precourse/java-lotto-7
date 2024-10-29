package lotto;

import lotto.io.ErrorLogger;
import lotto.io.LottoRequestReader;
import lotto.io.LottoResponseWriter;

public class Application {
    public static void main(String[] args) {
        // 0. 클래스 초기화
        LottoFactory lottoFactory = new LottoFactory();
        LottoWinningEvaluator lottoWinningEvaluator = new LottoWinningEvaluator();
        UserLottoRepository userLottoRepository = new UserLottoRepository();
        LottoMachine lottoMachine = new LottoMachine(userLottoRepository, lottoWinningEvaluator, lottoFactory);

        LottoPricePolicy lottoPricePolicy = new LottoPricePolicy();
        LottoRequestReader lottoRequestReader = new LottoRequestReader();
        LottoResponseWriter lottoResponseWriter = new LottoResponseWriter();
        ErrorLogger errorLogger = new ErrorLogger();

        LottoManager lottoManager = new LottoManager(lottoRequestReader, lottoResponseWriter, errorLogger, lottoMachine, lottoPricePolicy);

        // 1. 로또 구매 및 당첨 확인
        lottoManager.run();
    }
}
