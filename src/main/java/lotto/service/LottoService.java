package lotto.service;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

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
        BonusNumber bonusNumber = inputView.getBonusNumber();
        lottos.forEach(lotto -> {
            Integer result = getResult(winningNumbers, bonusNumber, lotto);
        });
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

    public Integer getResult(WinningNumbers  winningNumbers, BonusNumber bonusNumber, Lotto lotto) {
        return countWinningNumber(winningNumbers, lotto) + countBonusNumber(bonusNumber.value(), lotto);
    }

    public Integer countWinningNumber(WinningNumbers  winningNumbers, Lotto lotto) {
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
