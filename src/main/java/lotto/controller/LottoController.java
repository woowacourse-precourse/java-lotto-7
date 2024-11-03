package lotto.controller;

import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.parser.InputParser;
import lotto.utils.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        int quantity = setQuantity();

        List<Lotto> lottoList = setLottoNumbers(quantity);
        printLottoList(quantity, lottoList);

        WinningLotto winningLotto = setWinningLotto();
    }

    /**
     * 구매 갯수 set
     */
    private int setQuantity() {
        OutputView.printPurchaseAmountMessage();
        String input = InputView.getPurchaseAmount();

        return InputParser.parsePurchaseAmount(input);
    }

    /**
     * 구매한 List<Lotto> set
     */
    private List<Lotto> setLottoNumbers(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(i -> new Lotto(RandomNumberGenerator.generateLottoNumbers()))
                .toList();
    }

    /**
     * 구매한 로또 갯수 및 List<Lotto> 출력
     */
    private void printLottoList(int quantity, List<Lotto> lottoList) {
        OutputView.printLottoQuantity(quantity);

        lottoList.forEach(OutputView::printLottoList);
    }

    /**
     * WinningLotto set
     */
    private WinningLotto setWinningLotto() {
        OutputView.printWinningLottoNumbersMessage();
        String winningNumbers = InputView.getWinningLottoNumbers();

        OutputView.printBonusNumberMessage();
        int bonusNumber = InputView.getBonusNumber();

        return InputParser.parseWinningLotto(winningNumbers, bonusNumber);
    }

}
