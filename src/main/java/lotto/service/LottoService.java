package lotto.service;

import lotto.domain.LottoMachine;

public class LottoService {
    public void makeLotto(int count) {
        LottoMachine machine = LottoMachine.getInstance();
        machine.createLottos(count);
    }

    public void printLottoNumbers() {
        LottoMachine machine = LottoMachine.getInstance();
        machine.printAllLottoNumbers();
    }

}
