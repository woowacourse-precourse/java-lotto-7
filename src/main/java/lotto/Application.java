package lotto;

import lotto.application.LottoMachine;
import lotto.application.LottoManager;
import lotto.application.LottoWinningEvaluator;
import lotto.io.ErrorLogger;
import lotto.io.LottoRequestReader;
import lotto.io.LottoResponseWriter;

public class Application {
    public static void main(String[] args) {
        // 0. 클래스 초기화
        LottoMachine lottoMachine = lottoMachine();
        LottoManager lottoManager = lottoManager(lottoMachine);

        // 1. 로또 구매 및 당첨 확인
        lottoManager.run();
    }

    public static LottoMachine lottoMachine() {
        LottoFactory lottoFactory = new LottoFactory();
        LottoWinningEvaluator lottoWinningEvaluator = new LottoWinningEvaluator();
        UserLottoRepository userLottoRepository = new UserLottoRepository();
        return new LottoMachine(userLottoRepository, lottoWinningEvaluator, lottoFactory);
    }

    public static LottoManager lottoManager(LottoMachine lottoMachine) {
        LottoPricePolicy lottoPricePolicy = new LottoPricePolicy();
        LottoRequestReader lottoRequestReader = new LottoRequestReader();
        LottoResponseWriter lottoResponseWriter = new LottoResponseWriter();
        ErrorLogger errorLogger = new ErrorLogger();
        return new LottoManager(lottoRequestReader, lottoResponseWriter, errorLogger, lottoMachine, lottoPricePolicy);
    }
}
