package lotto.model;

import lotto.validation.LottoWinningNumberValidator;

import java.util.List;

public class LottoWinningNumber {

    private final List<Integer> lottoWinningNumbers;
    private final LottoWinningNumberValidator validator = new LottoWinningNumberValidator();

    public LottoWinningNumber(List<Integer> lottoWinningNumbers) {
        this.lottoWinningNumbers = lottoWinningNumbers;
        validator.validateLengthWinningNumber(lottoWinningNumbers);
        validator.validateDuplicationWinningNumber(lottoWinningNumbers);
    }


}
