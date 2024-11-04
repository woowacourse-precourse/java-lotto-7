package lotto;


import lotto.controller.LottoMachineController;
import lotto.domain.Lotto;
import lotto.domain.LottoMaker;
import lotto.domain.LottoMatcher;
import lotto.domain.WinningNumberMaker;


public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoMaker lottoMaker = new LottoMaker();
        WinningNumberMaker winningNumberMaker = new WinningNumberMaker();
        LottoMatcher lottoMatcher = new LottoMatcher();
        LottoMachineController lottoMachineController = new LottoMachineController(lottoMaker, winningNumberMaker, lottoMatcher);
        lottoMachineController.run();

    }
}
