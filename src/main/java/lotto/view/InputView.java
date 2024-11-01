package lotto.view;

import static lotto.constants.CommonConstants.INPUT_PROMPT_BONUS_NUMBER;
import static lotto.constants.CommonConstants.INPUT_PROMPT_PURCHASE_AMOUNT;
import static lotto.constants.CommonConstants.INPUT_PROMPT_RETYPE;
import static lotto.constants.CommonConstants.INPUT_PROMPT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Guess;
import lotto.enums.ErrorCode;
import lotto.exception.CommonException;
import lotto.service.LottoService;
import lotto.service.ValidatorService;

public class InputView {

    private final ValidatorService validatorService;
    private final LottoService lottoService;

    public InputView(ValidatorService validatorService, LottoService lottoService) {
        this.validatorService = validatorService;
        this.lottoService = lottoService;
    }

    public int getPurchaseInput() {
        System.out.println(INPUT_PROMPT_PURCHASE_AMOUNT);
        while (true) {
            try {
                int amount = Integer.parseInt(Console.readLine());
                validatorService.validatePurchaseAmount(amount);
                return amount;
            } catch (CommonException e) {
                System.out.println(e.getMessage());
                System.out.println(INPUT_PROMPT_RETYPE);
            } catch (NumberFormatException ne) {
                System.out.println("[ERROR] " + ErrorCode.PARSING_INTEGER_ERROR.getMessage());
                System.out.println(INPUT_PROMPT_RETYPE);
            }
        }
    }

    public List<Integer> getLottoInput() {
        System.out.println(INPUT_PROMPT_WINNING_NUMBERS);
        while (true) {
            try {
                String lotto = Console.readLine();
                validatorService.validateParsing(lotto);
                List<Integer> lottoNumbers = lottoService.generateLotto(lotto);
                validatorService.validateLottoNumbers(lottoNumbers);
                return lottoNumbers;
            } catch (CommonException e) {
                System.out.println(e.getMessage());
                System.out.println(INPUT_PROMPT_RETYPE);
            }
        }
    }

    public Guess getBonusNumberInput(List<Integer> winningNumbers) {
        System.out.println(INPUT_PROMPT_BONUS_NUMBER);
        while (true) {
            try {
                int bonusNumber = Integer.parseInt(Console.readLine());
                return new Guess(winningNumbers, bonusNumber);
            } catch (CommonException e) {
                System.out.println(e.getMessage());
                System.out.println(INPUT_PROMPT_RETYPE);
            }
        }
    }
}
