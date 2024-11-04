package lotto;

import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoManager lottoManager=new LottoManager();
        InputView inputView=new InputView();
        lottoManager.run();
        lottoManager.calculateStatistics();
    }
}
