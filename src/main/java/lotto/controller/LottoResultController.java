package lotto.controller;

import lotto.domain.Lotto;
import lotto.service.*;
import lotto.view.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoResultController {
    private List<Integer> winnerLottoNumbers;
    private Lotto winnerLottoNumber;
    private int bonusNumber;

    public void inputWinnerNumbers() {
        getWinnerNumber();
        getsBonusNumber();
    }

    private void getWinnerNumber() {
        while (true) {
            try {
                String winnerNumber = InputView.LOTTO_NUMBER.getInput();
                String[] winnerNumberItems = winnerNumber.split(",");
                winnerLottoNumbers = Arrays.stream(winnerNumberItems).map(Integer::parseInt).collect(Collectors.toList());
                winnerLottoNumber = new Lotto(winnerLottoNumbers);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        System.out.println();
    }

    private void getsBonusNumber() {
        while (true) {
            try {
                String bonusNumberItem = InputView.BONUS_NUMBER.getInput();
                bonusNumber = Integer.parseInt(bonusNumberItem);
                Validator.validateBonusNumber(winnerLottoNumbers, bonusNumber);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        System.out.println();
    }

    public Lotto getWinnerLottoNumber() {
        return winnerLottoNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}