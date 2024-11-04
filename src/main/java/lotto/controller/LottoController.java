package lotto.controller;

import lotto.service.LottoService;

public class LottoController {
    public static void buyLottoNums() {
        LottoService.getLottoNums();
    }

    public static void inputWinningNums() {
        LottoService.parseWinningNums();
    }

    public static void inputBonusNums() {
        LottoService.getBonusNum();
    }


}
