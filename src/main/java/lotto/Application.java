package lotto;

import lotto.io.LottoRequestReader;
import lotto.io.LottoResponseWriter;

public class Application {
    public static void main(String[] args) {
        // 0. 클래스 초기화
        LottoFactory lottoFactory = new LottoFactory();
        LottoWinningEvaluator lottoWinningEvaluator = new LottoWinningEvaluator();
        UserLottoRepository userLottoRepository = new UserLottoRepository();
        LottoMachine lottoMachine = new LottoMachine(userLottoRepository, lottoWinningEvaluator, lottoFactory);

        LottoPrice lottoPrice = new LottoPrice();
        LottoRequestReader lottoRequestReader = new LottoRequestReader();
        LottoResponseWriter lottoResponseWriter = new LottoResponseWriter();

        LottoManager lottoManager = new LottoManager(lottoRequestReader, lottoResponseWriter, lottoMachine, lottoPrice);

        // 1. 로또 구매 및 당첨 확인
        lottoManager.run();
    }
}
