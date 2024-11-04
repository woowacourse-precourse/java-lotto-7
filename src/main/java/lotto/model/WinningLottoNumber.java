package lotto.model;

import java.util.Arrays;
import java.util.List;

public class WinningLottoNumber {
    private final List<Integer> winningNumbers;

    private WinningLottoNumber(String userInputWinningLottoNumber){
        this.winningNumbers = Arrays.stream(userInputWinningLottoNumber.split(",")).map(Integer::parseInt).toList();
    }

    public static WinningLottoNumber of(String userInputWinningLottoNumber){
        return new WinningLottoNumber(userInputWinningLottoNumber);
    }
}
