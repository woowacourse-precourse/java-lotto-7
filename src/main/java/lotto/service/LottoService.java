package lotto.service;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {

    InputView inputView;
    OutputView outputView;

    public LottoService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Money money = getMoney();
        FortuneMachine fortuneMachine = getFortuneMachine();
        Lottos lottos = getLotto(fortuneMachine, money);
        showLotto(lottos);
        WinningNumbers winningNumbers = inputView.getWinningNumbers();
        BonusNumber bonusNumber = inputView.getBonusNumber(winningNumbers);
        Results results = new Results(lottos.stream()
                .map(lotto -> getResult(winningNumbers, bonusNumber, lotto))
                .toList());
        outputView.showResults(results, money);

    }

    public Money getMoney() {
        return inputView.getMoney();
    }

    public FortuneMachine getFortuneMachine() {
        return new FortuneMachine();
    }

    public Lottos getLotto(FortuneMachine fortuneMachine, Money money) {
        return fortuneMachine.buyLotto(money);
    }

    public void showLotto(Lottos lottos) {
        outputView.showLottos(lottos);
    }

    public Result getResult(WinningNumbers winningNumbers, BonusNumber bonusNumber, Lotto lotto) {
        return Result.findByCount(countWinningNumber(winningNumbers, lotto), countBonusNumber(bonusNumber.value(), lotto));
    }

    public Integer countWinningNumber(WinningNumbers winningNumbers, Lotto lotto) {
        return Math.toIntExact(winningNumbers.getKeySet()
                .stream()
                .filter(lotto::isMatched)
                .count());
    }

    public Integer countBonusNumber(Integer bonusNumber, Lotto lotto) {
        if (lotto.isMatched(bonusNumber)) {
            return 1;
        }
        return 0;
    }


}
