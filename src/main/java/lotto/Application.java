package lotto;

import lotto.controller.InputController;
import lotto.model.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchase = InputView.inputPurchase();
        List<List<Integer>> lottoLists = LottoMachine.generateLotto(purchase);
        OutputView.printLottoNumbers(lottoLists);
        String inputWinningNumbers = InputView.inputWinningNumbers();
        List<Integer> winnnigNumbers = InputController.parseIntegerList(inputWinningNumbers);

    }
}
