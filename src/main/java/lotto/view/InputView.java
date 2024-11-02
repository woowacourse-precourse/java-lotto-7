package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.Constants;
import lotto.validator.InputValidator;


public class InputView {
    private InputValidator inputValidator;

    public InputView() {
        inputValidator= new InputValidator();
    }


    public int inputLottoCost() {
        while(true){
            try {
                System.out.println(Constants.LOTTO_COST_INPUT);
                String lottoCost = Console.readLine();
                int lottoCostInt = validateLottoPrice(lottoCost);
                System.out.println();

                return lottoCostInt;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int validateLottoPrice(String lottoPrice) {
        inputValidator.validateEmpty(lottoPrice);
        int lottoPriceInt = inputValidator.validateNumber(lottoPrice);
        inputValidator.validateNumberRange(lottoPriceInt);
        inputValidator.validatePriceForm(lottoPriceInt);

        return lottoPriceInt;
    }

    public String inputWinningNumbers() {
        while(true){
            try {
                System.out.println(Constants.WINNING_LOTTO_INPUT);
                String winningNumbers = Console.readLine();
                validateWinningNumbers(winningNumbers);
                System.out.println();

                return winningNumbers;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void validateWinningNumbers(String lottoWinningNumbers) {
        inputValidator.validateEmpty(lottoWinningNumbers);
        inputValidator.validateNumbersForm(lottoWinningNumbers);
    }

    public int inputLottoBonusNumber() {
        while(true){
            try {
                System.out.println(Constants.BONUS_NUMBER_INPUT);
                String bonusNumber = Console.readLine();
                int bonusNumberInt = validateBonusNumbers(bonusNumber);
                System.out.println();

                return bonusNumberInt;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public int validateBonusNumbers(String bonusNumber) {
        inputValidator.validateEmpty(bonusNumber);
        int bonusNumberInt = inputValidator.validateNumber(bonusNumber);

        return bonusNumberInt;
    }
}
