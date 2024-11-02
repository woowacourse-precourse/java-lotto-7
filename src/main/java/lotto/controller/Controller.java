package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Model;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {

    private final InputView input;
    private final OutputView output;

    public Controller() {
        input = new InputView();
        output = new OutputView();
    }

    public void run() {
        Model model = init();
        printLottos(model);
        winningNumbers(model);
        bonusNumber(model);
        printResult(model);
    }

    private Model init() {
        while (true) {
            try {
                String amount = input.readAmount();
                return new Model(amount);
            } catch (IllegalArgumentException e) {
                output.printException(e.getMessage());
            }
        }

    }

    private void printLottos(Model model) {
        output.printCount(model.getCount());
        List<Lotto> lottos = model.getLottos();
        for (Lotto lotto : lottos) {
            output.printLotto(lotto.getNumbers());
        }
    }

    private void winningNumbers(Model model) {
        modelSetting(() -> {
            String winningNumbers = input.readWinningNumbers();
            model.setWinningNumbers(winningNumbers);
        });
    }

    private void bonusNumber(Model model) {
        modelSetting(() -> {
            String bonusNumber = input.readBonusNumber();
            model.setBonusNumber(bonusNumber);
        });
    }

    private void modelSetting(Setting setting) {
        while (true) {
            try {
                setting.set();
                return;
            } catch (IllegalArgumentException e) {
                output.printException(e.getMessage());
            }
        }
    }

    private void printResult(Model model) {

        output.printWinningDetail(model.getWinningMap());
        output.printResult(model.calculate());
    }
}

interface Setting {
    void set();
}