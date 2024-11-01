package service;

import domain.LottoMachine;
import java.util.List;

public class LottoMachineService {

    public LottoMachine initLottoMachine(List<Integer> winningNumbers, int bonusNumber) {
        return new LottoMachine(winningNumbers, bonusNumber);
    }
}
