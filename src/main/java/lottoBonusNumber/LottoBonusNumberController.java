package lottoBonusNumber;

import convert.SingleStringToNumConverter;
import java.util.List;

public class LottoBonusNumberController {
    private final List<Integer> seperatedLottoWinningNumbers;
    private final LottoBonusNumberInputter lottoBonusNumberInputter;
    private final LottoBonusNumberValidator lottoBonusNumberValidator;
    private final SingleStringToNumConverter singleStringToNumConverter;

    public LottoBonusNumberController(List<Integer> seperatedLottoWinningNumbers) {
        this.seperatedLottoWinningNumbers = seperatedLottoWinningNumbers;
        lottoBonusNumberInputter = new LottoBonusNumberInputter();
        lottoBonusNumberValidator = new LottoBonusNumberValidator();
        singleStringToNumConverter = new SingleStringToNumConverter();
    }

    public int runAndBringBonusNumber() {
        String bonusNumber = lottoBonusNumberInputter.runAndBringInput();
        lottoBonusNumberValidator.validateAllThing(bonusNumber, seperatedLottoWinningNumbers);

        return singleStringToNumConverter.convert(bonusNumber);
    }
}
