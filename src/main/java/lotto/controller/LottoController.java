package lotto.controller;

import java.util.List;
import java.util.function.Supplier;
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
        //구입금액을 입력받습니다.
        int money = getMoney();

        //로또를 만듭니다.
        Lottos lottos = makeLottos(money);

        //당첨번호와 보너스번호를 입력받고 당첨로또를 만듭니다.
        WinningLotto winningLotto = getWinningLotto();

        //로또들과 당첨로또를 비교하여 등수를 반환합니다.
        List<LottoRank> lottoRanks = lottoCheckService.checkRanks(winningLotto, lottos);

        //등수를 통계로 만들어 출력합니다.
        LottoStatisticsDto result = lottoStatisticsService.getLottoStatistics(lottoRanks, money);
        view.printResult(result);
    }

    public WinningLotto getWinningLotto() {
        return retryOnException(() -> {
            List<Integer> winningNumbers = view.getWinningNumbers();
            int bonusNumber = view.getBonusNumber();
            return lottoCreateService.createWinningLotto(winningNumbers, bonusNumber);
        });
    }

    public int getMoney() {
        return retryOnException(view::getMoney);
    }

    public Lottos makeLottos(int money) {
        return retryOnException(() -> {
            Lottos lottos = lottoCreateService.createLottosWithMoney(money);
            view.printLottos(lottos);
            return lottos;
        });
    }

    private <T> T retryOnException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
