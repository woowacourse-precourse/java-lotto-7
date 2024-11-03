package lotto;
import lotto.controller.LottoMachineController;
public class Application {
    public static void main(String[] args) {
        lotto.controller.LottoMachineFactory factory = new lotto.controller.LottoMachineFactory();
        new LottoMachineController(factory).runLottoMachine();
    }
}