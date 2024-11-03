package lottoBonusNumber;

import java.util.List;

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
        String bonusNumber = lottoBonusNumberInputter.runAndBringInput();
        lottoBonusNumberValidator.validateAllThing(bonusNumber, lottoWinningNumber);

        return Integer.parseInt(bonusNumber);
    }
}
