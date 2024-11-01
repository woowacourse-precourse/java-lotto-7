package lottoWinningNumber;

import convert.ListStringToNumConverter;
import java.util.List;

public class LottoWinningNumberController {
    private final LottoWinningNumberInputter lottoWinningNumberInputter;
    private final LottoWinningNumberDelimiter lottoWinningNumberDelimiter;
    private final LottoWinningNumberValidator lottoWinningNumberValidator;
    private final ListStringToNumConverter listStringToNumConverter;

    public LottoWinningNumberController() {
        this.lottoWinningNumberInputter = new LottoWinningNumberInputter();
        this.lottoWinningNumberDelimiter = new LottoWinningNumberDelimiter();
        this.lottoWinningNumberValidator = new LottoWinningNumberValidator();
        this.listStringToNumConverter = new ListStringToNumConverter();
    }

    public List<Integer> runAndBringWinningNumbers() {
        String lottoWinningNumber = lottoWinningNumberInputter.runAndBringInput();
        List<String> seperatedLottoWinningNumbers = lottoWinningNumberDelimiter.runAndBringSeperatedLottoWinningNumbers(
                lottoWinningNumber);
        lottoWinningNumberValidator.validateAllThing(seperatedLottoWinningNumbers);

        return listStringToNumConverter.convert(seperatedLottoWinningNumbers);
    }
}
