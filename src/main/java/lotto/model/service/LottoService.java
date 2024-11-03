package lotto.model.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.domain.BonusNumber;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoMachine;

public class LottoService {

    public int moneyValidator(String inputMoney) {
        moneyNotNullValidator(inputMoney);
        return moneyNumberValidator(inputMoney);
    }

    public List<Lotto> activateLottoMachine(int money) {
        LottoMachine lottoMachine = new LottoMachine(money);
        return lottoMachine.multipleLottoGenerator();
    }

    public List<Integer> winningNumbersGenerator(String inputWinningNumbers) {
        winningNumbersNotNullValidator(inputWinningNumbers);
        return winningNumbersParser(inputWinningNumbers);
    }


    public void bonusNumberValidator(String bonusNumber) {

    }

    public void setWinningNumbers(List<Integer> winningNumbers, BonusNumber bonusNumber) {

    }

    private void moneyNotNullValidator(String inputMoney) {
        if (inputMoney.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 로또를 구매하려는 금액을 입력해 주세요.");
        }
    }

    private int moneyNumberValidator(String inputMoney) {
        try {
            return Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또를 구매하려는 금액을 숫자로 입력해 주세요.");
        }
    }

    private void winningNumbersNotNullValidator(String inputWinningNumbers) {
        if (inputWinningNumbers.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호가 입력되지 않았습니다.");
        }
    }

    private List<Integer> winningNumbersParser(String inputWinningNumbers) {
        List<String> splitLottoMainNumbers = Arrays.stream(inputWinningNumbers.split(",", -1)).toList();
        List<Integer> winningNumbers = new ArrayList<>();
        for (String splitNumber : splitLottoMainNumbers) {
            winningNumbers.add(winningNumbersNumericValidator(splitNumber));
        }
        return winningNumbers;
    }

    private int winningNumbersNumericValidator(String inputWinningNumbers) {
        try {
            return Integer.parseInt(inputWinningNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야합니다.");
        }
    }

}
