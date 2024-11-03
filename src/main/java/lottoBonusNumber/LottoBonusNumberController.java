package lottoBonusNumber;

import java.util.List;

public class LottoBonusNumberController {
    private final LottoBonusNumberInputter lottoBonusNumberInputter;
    private final LottoBonusNumberValidator lottoBonusNumberValidator;

    public LottoBonusNumberController() {
        lottoBonusNumberInputter = new LottoBonusNumberInputter();
        lottoBonusNumberValidator = new LottoBonusNumberValidator();
    }

    public int runAndBringBonusNumber(List<Integer> seperatedLottoWinningNumbers) {
        String bonusNumber = lottoBonusNumberInputter.runAndBringInput();
        lottoBonusNumberValidator.validateAllThing(bonusNumber, seperatedLottoWinningNumbers);

        return Integer.parseInt(bonusNumber);
    }
}
