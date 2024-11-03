package lotto.service;

import lotto.domain.WinningNumbers;

import java.util.List;

public class WinningNumbersService {
    public WinningNumbers getWinningNumbers (String inputWinningNumbers) {
        return new WinningNumbers(inputWinningNumbers);
    }
}
