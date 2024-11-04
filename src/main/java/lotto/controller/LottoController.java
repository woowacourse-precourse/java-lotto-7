package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    private LottoGenerator lottoGenerator;

    public void run() {
        lottoGenerator = new LottoGenerator();

        Money money=getMoney();
        OutputView.printBuyLottoCount(money.getLottoCount());

        List<Lotto> lottos=lottoGenerator.generateLottos(money.getLottoCount());
        OutputView.printLottoList(lottos);

        WinningLotto winningLotto=getWinningLotto();

        LottoResult result = calculateResult(lottos, winningLotto);

        OutputView.printLottResult(result);
        OutputView.printRate(result.calculateRate(money));
    }

    private Money getMoney() {
        String input = InputView.getMoney();
        return new Money(input);
    }

    private WinningLotto getWinningLotto() {

        String inputWinningNumbers = InputView.getWinningNumber();
        String inputBonusNumbers=InputView.getBonusNumber();
        List<Integer> winningNumbers = Arrays.stream(inputWinningNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Integer bonusNumber = Integer.parseInt(inputBonusNumbers);

        return new WinningLotto(winningNumbers,bonusNumber);

        }
    private LottoResult calculateResult(List<Lotto> lottos, WinningLotto winningLotto) {
        return new LottoResult(lottos, winningLotto);
    }
}


