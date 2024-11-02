package lotto.controller;

import lotto.Factory.BonusGeneratorFactory;
import lotto.service.BonusGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.PrintMessage;

public class BonusController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BonusGenerator bonusGenerator;

    public BonusController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bonusGenerator = inputLottoBonus();
    }

    private BonusGenerator inputLottoBonus() {
        outputView.printlnMessage(PrintMessage.LINE_SPACE);
        outputView.printlnMessage(PrintMessage.INPUT_LOTTO_BONUS_NUMBER);

        String lottoBonus = inputView.inputUser();
        return BonusGeneratorFactory.create(lottoBonus);
    }

    public BonusGenerator getBonusGenerator() {
        return bonusGenerator;
    }
}
