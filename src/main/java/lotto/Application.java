package lotto;

import lotto.service.CheckLottoNumber;
import lotto.service.EarningCalculator;
import lotto.service.LottoGenerator;
import lotto.view.InputHandler;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputHandler inputHandler = new InputHandler();
        LottoGenerator lottoGenerator = new LottoGenerator();
        CheckLottoNumber checkLottoNumber = new CheckLottoNumber();
        EarningCalculator earningCalculator = new EarningCalculator();

        LottoManager lottoManager = new LottoManager(inputHandler, lottoGenerator, checkLottoNumber, earningCalculator);

        lottoManager.manageLotto();
    }
}
