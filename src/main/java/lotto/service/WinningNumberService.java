package lotto.service;

import java.util.List;
import lotto.domain.WinningNumber;

public class WinningNumberService {
    public WinningNumber createWinningNumber(List<Integer> winningNumber, int bonusNumber) {
        return new WinningNumber(winningNumber, bonusNumber);
    }

    public int getMatchCount(List<Integer> lottoNumber, List<Integer> winningNumber) {
        return (int) lottoNumber.stream()
                .filter(winningNumber::contains)
                .count();
    }

}
