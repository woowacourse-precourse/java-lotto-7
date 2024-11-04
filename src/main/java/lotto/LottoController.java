package lotto;

import camp.nextstep.edu.missionutils.Console;

public class LottoController {
    private final LottoService lottoService;

    public LottoController() {
        this.lottoService = new LottoService();
    }

    public void run() {
        // 로또 구입 금액 입력
        int amountSpent = lottoService.buy_lotto();

        // 로또 번호 구매
        lottoService.make_lotto(amountSpent);

        // 구매한 로또 번호 출력
        lottoService.printLottos();

        // 당첨 번호 입력
        lottoService.win_number();

        // 보너스 번호 입력
        int bonusNum = lottoService.bonus();

        // 당첨 통계 출력
        lottoService.printWinningStatistics(amountSpent, bonusNum);
    }
}