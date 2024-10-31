package lotto.service.numbers;

import java.util.List;
import lotto.domain.Lotto;
import lotto.utils.Parser;
import lotto.validator.LottoValidator;

public class WinningLottoService {

    public Lotto generateWinningLotto(String winningNumbers) {
        List<Integer> convertedWinningNumbers = Parser.parsingNumbers(winningNumbers);
        LottoValidator.validateProcess(convertedWinningNumbers);
        return new Lotto(convertedWinningNumbers);
    }
}
