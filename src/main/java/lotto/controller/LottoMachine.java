package lotto.controller;

import lotto.service.LottoMachineService;

public class LottoMachine {
    LottoMachineService lottoMachineService;

    public LottoMachine() {
        lottoMachineService = new LottoMachineService();
    }

    public void start() {
        lottoMachineService.purchaseLotto();

        // 당첨 번호 입력

        // 로또 당첨 로직

        //통계 계산
    }
}
