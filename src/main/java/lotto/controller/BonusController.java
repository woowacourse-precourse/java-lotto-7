package lotto.controller;

import lotto.domain.Lotto;
import lotto.factory.BonusGeneratorFactory;
import lotto.service.generator.BonusGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.message.PrintMessage;

public class BonusController {

    private final InputView inputView;
    private final OutputView outputView;

    public BonusController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public BonusGenerator inputBonus(Lotto winning) {
        while (true) {
            BonusGenerator newBonusGenerator = inputLottoBonus(winning);
            outputView.printlnMessage(PrintMessage.LINE_SPACE);
            if (newBonusGenerator != null) {
                return newBonusGenerator;
            }
        }
    }

    private BonusGenerator inputLottoBonus(Lotto winning) {
        try {
            outputView.printlnMessage(PrintMessage.INPUT_LOTTO_BONUS_NUMBER);
            String lottoBonus = inputView.inputUser();
            return BonusGeneratorFactory.create(winning, lottoBonus);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR");
        }
        return null;
    }
}
