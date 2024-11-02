package lotto.vendingmachine;

import java.util.List;

public class VendingMachineController {

    private final VendingMachineService vendingMachineService;

    public VendingMachineController(VendingMachineService vendingMachineService) {
        this.vendingMachineService = vendingMachineService;
    }

    public void generateLottoTickets(int amount) {
        List<Lotto> lottos = vendingMachineService.ticket(amount);
        vendingMachineService.recordLottos(lottos);
    }

}
