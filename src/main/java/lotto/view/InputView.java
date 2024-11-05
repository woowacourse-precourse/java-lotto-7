package lotto.view;

import static lotto.constants.CommonConstants.INPUT_PROMPT_BONUS_NUMBER;
import static lotto.constants.CommonConstants.INPUT_PROMPT_PURCHASE_AMOUNT;
import static lotto.constants.CommonConstants.INPUT_PROMPT_RETYPE;
import static lotto.constants.CommonConstants.INPUT_PROMPT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Guess;
import lotto.domain.Lotto;
import lotto.exception.CommonException;
import lotto.exception.FormatException;
import lotto.service.LottoService;
import lotto.service.StringParser;
import lotto.service.ValidatorService;

public class InputView {

    private final ValidatorService validatorService;
    private final LottoService lottoService;
    private final StringParser stringParser;

    public InputView(ValidatorService validatorService, LottoService lottoService, StringParser stringParser) {
        this.validatorService = validatorService;
        this.lottoService = lottoService;
        this.stringParser = stringParser;
    }

    public int getPurchaseInput() {
        System.out.println(INPUT_PROMPT_PURCHASE_AMOUNT);
        while (true) {
            try {
                int amount = stringParser.parseToInteger(Console.readLine());
                validatorService.validatePurchaseAmount(amount);
                return amount;
            } catch (CommonException | FormatException e) {
                System.out.println(e.getMessage());
                System.out.println(INPUT_PROMPT_RETYPE);
            }
        }
    }

    public Lotto getLottoInput() {
        System.out.println(INPUT_PROMPT_WINNING_NUMBERS);
        while (true) {
            try {
                String lotto = Console.readLine();
                List<Integer> lottoNumbers = lottoService.generateLotto(lotto);
                return new Lotto(lottoNumbers);
            } catch (CommonException | FormatException e) {
                System.out.println(e.getMessage());
                System.out.println(INPUT_PROMPT_RETYPE);
            }
        }
    }

    public Guess getBonusNumberInput(List<Integer> winningNumbers) {
        System.out.println(INPUT_PROMPT_BONUS_NUMBER);
        while (true) {
            try {
                int bonusNumber = stringParser.parseToInteger(Console.readLine());
                return new Guess(winningNumbers, bonusNumber);
            } catch (CommonException | FormatException e) {
                System.out.println(e.getMessage());
                System.out.println(INPUT_PROMPT_RETYPE);
            }
        }
    }
}
