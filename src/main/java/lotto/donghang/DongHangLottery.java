package lotto.donghang;

import lotto.AppConfig;
import lotto.io.InputReader;
import lotto.io.OutputWriter;
import lotto.util.InputValidator;
import lotto.vendingmachine.Lotto;
import lotto.vendingmachine.VendingMachineController;

import java.util.List;

public class DongHangLottery {

    private static final AppConfig appConfig = new AppConfig();
    private static final InputReader inputReader = new InputReader();
    private static final OutputWriter outputWriter = new OutputWriter();

    public static void sellLotto() {
        VendingMachineController vendingMachineController = appConfig.vendingMachineController();
        while (true) {
            try {
                int money = inputReader.readPurchaseAmount();
                InputValidator.validatePurchaseAmount(money);
                vendingMachineController.generateLottoTickets(money / 1000);

                List<Lotto> lottos = vendingMachineController.getIssuedLottoTickets();
                outputWriter.write(lottos);
                break;
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }

}
