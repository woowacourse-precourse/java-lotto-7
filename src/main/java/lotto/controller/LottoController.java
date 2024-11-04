package lotto.controller;

import java.util.List;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.dto.LottoStatisticsDto;
import lotto.service.LottoCheckService;
import lotto.service.LottoCreateService;
import lotto.service.LottoStatisticsService;
import lotto.view.View;

public class LottoController {

    private final View view;
    private final LottoCreateService lottoCreateService;
    private final LottoCheckService lottoCheckService;
    private final LottoStatisticsService lottoStatisticsService;

    public LottoController(View view) {
        this.view = view;
        lottoCreateService = new LottoCreateService();
        lottoCheckService = new LottoCheckService();
        lottoStatisticsService = new LottoStatisticsService();
    }

    public void run() {
        //구입금액을 입력받고 로또를 만듭니다.
        String money = view.getMoney();
        Lottos lottos = lottoCreateService.createLottosWithMoney(money);
        view.printLottos(lottos);

        //당첨번호와 보너스번호를 입력받고 당첨로또를 만듭니다.
        String winningNumbers = view.getWinningNumbers();
        String bonusNumber = view.getBonusNumber();
        WinningLotto winningLotto = lottoCreateService.createWinningLotto(winningNumbers, bonusNumber);

        //로또들과 당첨로또를 비교하여 등수를 반환합니다.
        List<LottoRank> lottoRanks = lottoCheckService.checkRanks(winningLotto, lottos);

        //등수를 통계로 만들어 출력합니다.
        LottoStatisticsDto result = lottoStatisticsService.getLottoStatistics(lottoRanks, Integer.parseInt(money));
        view.printResult(result);
    }
}
