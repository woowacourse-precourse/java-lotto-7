package lotto;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.LottoSeller;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        String lottoPurchaseMoney = inputView.inputLottoPurchaseMoney();

        LottoSeller lottoSeller = new LottoSeller();
        Customer customer = new Customer(Integer.parseInt(lottoPurchaseMoney));
        customer.buyLotto(lottoSeller);

        List<Lotto> lottos = customer.getLottos();
        outputView.printPurchaseCount(lottos.size());
        outputView.printPurchaseLottos(lottos);

        String winningNumber = inputView.inputWinningNumber();
        List<Integer> winningNumbers = Stream.of(winningNumber.split(","))
                .map(Integer::valueOf)
                .toList();

        outputView.printEmptyLine();

        String inputBonusNumber = inputView.inputBonusNumber();
        int bonusNumber = Integer.parseInt(inputBonusNumber);

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        LottoResult lottoResult = customer.calculateLottoResult(winningLotto);

        outputView.printLottoResults(lottoResult);
    }
}
