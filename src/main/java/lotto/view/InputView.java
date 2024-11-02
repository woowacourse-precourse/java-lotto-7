package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Constants;
import lotto.validator.InputValidator;


public class InputView {
    private InputValidator inputValidator;

    public InputView() {
        inputValidator= new InputValidator();
    }


    public int inputLottoPrice() {
        while(true){
            try {
                System.out.println(Constants.PURCHASE_LOTTO_INPUT);
                String lottoPrice = Console.readLine();
                int LottoPriceInt = validateLottoPrice(lottoPrice);
                System.out.println();

                return LottoPriceInt;
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

    public String inputLottoWinningNumbers() {
        while(true){
            try {
                System.out.println(Constants.WINNING_LOTTO_INPUT);
                String WinningLotto = Console.readLine();
                validateWinningNumbers(WinningLotto);
                System.out.println();

                return WinningLotto;
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
