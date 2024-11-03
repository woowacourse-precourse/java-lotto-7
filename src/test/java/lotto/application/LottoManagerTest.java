package lotto.application;

import lotto.LottoFactory;
import lotto.LottoPricePolicy;
import lotto.UserLottoRepository;
import lotto.io.ErrorLogger;
import lotto.io.LottoRequestReader;
import lotto.io.LottoResponseWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoManagerTest {

    @Test
    @DisplayName("로또 매니저에게 잘못된 입력이 주어진다면, 다시 입력받는다.")
    void run() {
        LottoFactory lottoFactory = new LottoFactory();
        LottoWinningEvaluator lottoWinningEvaluator = new LottoWinningEvaluator();
        UserLottoRepository userLottoRepository = new UserLottoRepository();
        LottoMachine lottoMachine = new LottoMachine(userLottoRepository, lottoWinningEvaluator, lottoFactory);

        LottoPricePolicy lottoPricePolicy = new LottoPricePolicy();
        LottoRequestReaderSpy lottoRequestReaderSpy = new LottoRequestReaderSpy();
        LottoResponseWriter lottoResponseWriter = new LottoResponseWriter();
        ErrorLogger errorLogger = new ErrorLogger();

        LottoManager lottoManager = new LottoManager(lottoRequestReaderSpy, lottoResponseWriter, errorLogger, lottoMachine, lottoPricePolicy);

        // when
        lottoManager.run();

        // then
        assertEquals(2, lottoRequestReaderSpy.getPurchaseMoneyCount);
        assertEquals(2, lottoRequestReaderSpy.getLottoNumbersCount);
        assertEquals(2, lottoRequestReaderSpy.getBonusMoneyCount);
    }


    public static class LottoRequestReaderSpy extends LottoRequestReader {
        int getPurchaseMoneyCount = 0;

        int getLottoNumbersCount = 0;
        int getBonusMoneyCount = 0;



        @Override
        public int getPurchaseMoney() {
            if(getPurchaseMoneyCount == 0) {
                getPurchaseMoneyCount++;
                return 1001;
            }
            getPurchaseMoneyCount++;
            return 1000;
        }

        @Override
        public List<Integer> getLottoNumbers() {
            if(getLottoNumbersCount == 0) {
                getLottoNumbersCount++;
                return List.of(1, 2, 3, 4, 5, -1111);
            }
            getLottoNumbersCount++;
            return List.of(1, 2, 3, 4, 5, 6);
        }

        @Override
        public int getBonusNumber() {
            if(getBonusMoneyCount == 0) {
                getBonusMoneyCount++;
                return -1;
            }
            getBonusMoneyCount++;
            return 11;
        }
    }
}