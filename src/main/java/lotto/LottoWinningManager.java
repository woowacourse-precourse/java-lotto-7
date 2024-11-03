package lotto;

import java.util.List;

public class LottoWinningManager {
    InputHandler inputHandler = new InputHandler();
    PrintManager printManager = new PrintManager();

    public Lotto getWinningLotto() {
        while (true) {
            printManager.printWinningLottoNotice();
            List<Integer> inputLotto = inputHandler.parseToList(inputHandler.getInput());
            if (inputLotto == null) {
                continue;
            }
            if (NumberValidator.isValidLotto(inputLotto)) {
                Lotto winningLotto = new Lotto(inputLotto);
                return winningLotto;
            }
        }
    }

    public int getBonusNumber(Lotto winningLotto) {
        while (true) {
            printManager.printBonusNotice();
            String bonus = inputHandler.getInput();
            if (!NumberValidator.isValidNumber(bonus)) {
                continue;
            }
            final int bonusNumber = Integer.parseInt(bonus);
            if (NumberValidator.isValidBonus(bonusNumber, winningLotto)) {
                return bonusNumber;
            }
        }


        // final int bonusNumber;
        // bonusNumber = Integer.parseInt(inputHandler.getInput());
        // return bonusNumber;
    }

    
}
