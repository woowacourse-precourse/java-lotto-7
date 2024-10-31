package lotto;

import camp.nextstep.edu.missionutils.Console;
import controller.LottoController;
import factory.WinningLottoNumFactory;
import model.LottoCollection;
import view.InputView;
import view.OutputView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoCollection lottoCollection = new LottoCollection();
        LottoController lottoController = new LottoController(inputView, outputView,lottoCollection);
        lottoController.run();
        Console.close();
    }
}
