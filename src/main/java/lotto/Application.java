package lotto;

import lotto.machine.LottoMachine;

public class Application {
    public static void main(String[] args) {
        Validator validator = new Validator();
        OutputHandler outputHandler = new OutputHandler();
        LottoMachine machine = new LottoMachine(validator, outputHandler);

        machine.requestPurchasePrice();
        machine.generateLottos();
        machine.printLottoStatus();
        machine.requestWinnerNumbers();
        machine.requestBonusNumber();
        machine.printLottoResult();
    }
}
