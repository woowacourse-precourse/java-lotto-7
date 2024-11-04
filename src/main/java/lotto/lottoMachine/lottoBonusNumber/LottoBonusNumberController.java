package lotto.lottoMachine.lottoBonusNumber;

import java.util.List;
import lotto.utils.StaticFinalMessages;

public class LottoBonusNumberController {
    private final LottoBonusNumberInputter lottoBonusNumberInputter;
    private final LottoBonusNumberValidator lottoBonusNumberValidator;
    private final List<Integer> lottoWinningNumber;

    public LottoBonusNumberController(List<Integer> lottoWinningNumber) {
        lottoBonusNumberInputter = new LottoBonusNumberInputter();
        lottoBonusNumberValidator = new LottoBonusNumberValidator();
        this.lottoWinningNumber = lottoWinningNumber;
    }

    public int getBonusNumber() {
        while (true) {
            String bonusNumber = lottoBonusNumberInputter.runAndBringInput();
            if (lottoBonusNumberValidator.validateAllThing(bonusNumber, lottoWinningNumber)) {
                return Integer.parseInt(bonusNumber);
            } else {
                System.out.println(StaticFinalMessages.ERROR_TEXT_INFRONT_OF_DETAILS
                        + StaticFinalMessages.RECOMMAND_MESSAGE_FOR_ENTERING_CORRECT_LOTTO_BONUS_NUMBER);
            }
        }
    }
}
