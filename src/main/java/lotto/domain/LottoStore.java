package lotto.domain;

import static lotto.constant.Prompt.ENTER_BONUS_NUMBER_TEXT;
import static lotto.constant.Prompt.ENTER_PURCHASE_AMOUNT_TEXT;
import static lotto.constant.Prompt.ENTER_WINNING_NUMBER_TEXT;
import static lotto.constant.Prompt.RESULT_PURCHASE_AMOUNT_AND_AUTOMATIC_LOTTO_TEMPLATE;
import static lotto.constant.Prompt.RESULT_WINNING_STATISTICS_LOTTO_TEMPLATE;
import static lotto.constant.Prompt.display;
import static lotto.constant.Prompt.displayEmptyLine;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.manager.AutomaticLottoMachine;
import lotto.domain.manager.LottoStatistics;
import lotto.domain.manager.WinningLotto;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoNumber;
import lotto.utils.Delimiter;
import lotto.utils.InputValidator;
import lotto.utils.NumberParser;

public class LottoStore {
    private static final String WINNING_NUMBER_DELIMITER = ",";

    public void open() {
        var automaticLottoMachine = enterPurchaseAmount();
        RESULT_PURCHASE_AMOUNT_AND_AUTOMATIC_LOTTO_TEMPLATE.display(
                automaticLottoMachine.getQuantity(),
                automaticLottoMachine);

        Lotto winingLotto = enterWinningNumber();
        var winningLotto = enterBonusNumber(winingLotto);
        var lottoStatistics = new LottoStatistics(automaticLottoMachine, winningLotto);
        RESULT_WINNING_STATISTICS_LOTTO_TEMPLATE.display(lottoStatistics);
    }

    private Lotto enterWinningNumber() {
        try {
            ENTER_WINNING_NUMBER_TEXT.display();
            String rawNumbers = Console.readLine();

            InputValidator.notNullAndEmpty(rawNumbers);
            var separatedNumbers = Delimiter.separate(rawNumbers, WINNING_NUMBER_DELIMITER);
            var numbers = NumberParser.parse(separatedNumbers);

            Lotto lotto = new Lotto(numbers);
            displayEmptyLine();

            return lotto;
        } catch (IllegalArgumentException e) {
            display(e.getMessage());
            return enterWinningNumber();
        }
    }

    private AutomaticLottoMachine enterPurchaseAmount() {
        try {
            ENTER_PURCHASE_AMOUNT_TEXT.display();
            String rawAmount = Console.readLine();

            InputValidator.notNullAndEmpty(rawAmount);
            int amount = NumberParser.parse(rawAmount);

            var automaticLottoMachine = new AutomaticLottoMachine(amount);
            displayEmptyLine();

            return automaticLottoMachine;
        } catch (IllegalArgumentException e) {
            display(e.getMessage());

            return enterPurchaseAmount();
        }
    }

    private WinningLotto enterBonusNumber(Lotto winingLotto) {
        try {
            ENTER_BONUS_NUMBER_TEXT.display();
            String rawBonusNumber = Console.readLine();

            int bonusNumber = NumberParser.parse(rawBonusNumber);

            var bonus = new LottoNumber(bonusNumber);
            var winningLotto = new WinningLotto(winingLotto, bonus);

            displayEmptyLine();
            return winningLotto;
        } catch (IllegalArgumentException e) {
            display(e.getMessage());

            return enterBonusNumber(winingLotto);
        }
    }
}
