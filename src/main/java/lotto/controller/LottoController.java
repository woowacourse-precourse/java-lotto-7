package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoIssuer;
import lotto.domain.Lottos;
import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.generator.RandomLottoNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoNumberGenerator = new RandomLottoNumberGenerator();
    }

    public void start() {
        String purchaseAmount = inputPurchaseAmount();
        Lottos lottos = issueLottos(purchaseAmount);
        printLottos(lottos);

        Lotto lotto = createWinningLotto();
        int bonusNumber = createBonusNumber(lotto.getNumbers());

        Console.close();
    }

    private String inputPurchaseAmount() {
        return inputView.inputPurchaseAmount();
    }

    private Lottos issueLottos(String purchaseAmount) {
        return LottoIssuer.issue(purchaseAmount, lottoNumberGenerator);
    }

    private void printLottos(Lottos lottos) {
        List<Lotto> lottoList = lottos.lottos();

        outputView.printLottoPurchaseCountMessage(lottoList.size());
        for (Lotto lotto : lottoList) {
            outputView.printLottoNumbers(lotto.getNumbers());
        }
    }

    private Lotto createWinningLotto() {
        String inputWinningNumbers = inputView.inputWinningNumbers();
        return Lotto.createLotto(inputWinningNumbers);
    }

    private int createBonusNumber(List<Integer> winningNumbers) {
        return inputView.inputBonusNumber(winningNumbers);
    }

}
