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
        this.bonusGenerator = inputBonus(winnings);
    }

    private BonusGenerator inputBonus(Lotto winning) {
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
            return BonusGenerator.create(winning, lottoBonus);
        } catch (IllegalArgumentException e) {
            System.out.println("ERROR");
        }
        return null;
    }

    public BonusGenerator getBonusGenerator() {
        return bonusGenerator;
    }
}
