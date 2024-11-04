package lotto.service;

import java.util.List;
import lotto.domain.LottoMachine;
import lotto.domain.WinningNumbers;

public class LottoService {
    public void makeLotto(int count) {
        LottoMachine machine = LottoMachine.getInstance();
        machine.createLottos(count);
    }

    public void printLottoNumbers() {
        LottoMachine machine = LottoMachine.getInstance();
        machine.printAllLottoNumbers();
    }

    public void makeWinningLotto(List<Integer> numbers, int bonusNumber) {
        LottoMachine machine = LottoMachine.getInstance();
        machine.createWinningNumbers(numbers, bonusNumber);
    }

    public void countWonLotto(List<Integer> numbers, int bonusNumber) {
        WinningNumbers winningNumbers = WinningNumbers.getInstance(numbers, bonusNumber);
        winningNumbers.matchWinningNumbers();
    }

}
