package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.generator.BonusGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.PrintMessage;

public class BonusController {

    private final InputView inputView;
    private final OutputView outputView;
    private final BonusGenerator bonusGenerator;

    public BonusController(InputView inputView, OutputView outputView, Lotto winnings) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.bonusGenerator = inputLottoBonus(winnings);
    }

    private BonusGenerator inputLottoBonus(Lotto winning) {
        outputView.printlnMessage(PrintMessage.INPUT_LOTTO_BONUS_NUMBER);

        String lottoBonus = inputView.inputUser();
        outputView.printlnMessage(PrintMessage.LINE_SPACE);
        return BonusGenerator.create(winning, lottoBonus);
    }

    public BonusGenerator getBonusGenerator() {
        return bonusGenerator;
    }
}
