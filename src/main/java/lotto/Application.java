package lotto;

import lotto.service.LottoMachineService;

public class Application {
    public static void main(String[] args) {
        LottoMachineService lottoMachineService = new LottoMachineService();
        lottoMachineService.run();
    }
}
