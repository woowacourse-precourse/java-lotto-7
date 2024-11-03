package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int inputPrice = InputView.getInputPrice();
        List<Lotto> lottos = LottoService.createLottos(inputPrice);
        OutputView.displayLotto(lottos);

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber(winningNumbers);

        int[] matchCounts = LottoService.calculateMatchCounts(lottos, winningNumbers, bonusNumber);
        OutputView.displayResults(matchCounts, inputPrice);
    }
}
