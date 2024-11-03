package lottoWinningNumber;

import java.util.List;

public class LottoWinningNumberController {
    private final LottoWinningNumberInputter lottoWinningNumberInputter;
    private final LottoWinningNumberDelimiter lottoWinningNumberDelimiter;
    private final LottoWinningNumberValidator lottoWinningNumberValidator;

    public LottoWinningNumberController() {
        this.lottoWinningNumberInputter = new LottoWinningNumberInputter();
        this.lottoWinningNumberDelimiter = new LottoWinningNumberDelimiter();
        this.lottoWinningNumberValidator = new LottoWinningNumberValidator();
    }

    public List<Integer> getWinningNumbers() {
        String lottoWinningNumber = lottoWinningNumberInputter.runAndBringInput();
        List<String> seperatedLottoWinningNumbers = lottoWinningNumberDelimiter.runAndBringSeperatedLottoWinningNumbers(
                lottoWinningNumber);
        lottoWinningNumberValidator.validateAllThing(seperatedLottoWinningNumbers);

        return lottoWinningNumberValidator.convertToCompareNumbers(seperatedLottoWinningNumbers);
    }
}
