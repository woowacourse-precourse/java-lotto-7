package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WinningNumberMaker {

    private final WinningNumber winningNumber;

    public WinningNumberMaker() {
        this.winningNumber = new WinningNumber();
    }

    public void setWinningNumber(String winningNumber) {
        this.winningNumber.setWinningNumbers(transWinningNumberToList(winningNumber));
    }

    public void setBonusNumber(String bonusNumber) {
        this.winningNumber.setBonusNumber(transBonusInputToInt(bonusNumber));
    }

    public WinningNumber getWinningNumber() {
        return this.winningNumber;
    }

    public int transBonusInputToInt(String inputBonusNumber) {
        try {
            int bonusNumber = Integer.parseInt(inputBonusNumber);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 올바른 숫자형식의 보너스 번호를 입력해주세요.");
        }

    }

    public List<Integer> transWinningNumberToList(String winningNumber) {
        try {
            return Arrays.stream(winningNumber.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 올바른 숫자를 입력해 주세요.");
        }
    }


}
