package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.UserLotto;
import lotto.domain.WinningRank;
import lotto.service.LottoManagementService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoManagementController {
    private static final int LOTTO_PRICE = 1000;

    private final LottoManagementService lottoManagementService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoManagementController(LottoManagementService lottoManagementService,
                                     InputView inputView, OutputView outputView) {
        this.lottoManagementService = lottoManagementService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void executeLottoGame() {
        int cost = createUserLotto();

        createLotto();
        drawLottoNumbers();
        createWinningStatistics(cost);
    }

    // 유저가 구매한 로또 수만큼 로또를 생성하여 저장하고, 구매한 로또 정보를 출력
    private int createUserLotto() {
        int cost = inputView.cost();
        int count = cost / LOTTO_PRICE;

        for (int i = 0; i < count; i++) {
            UserLotto userLotto = lottoManagementService.createLottoNumbers();
            lottoManagementService.joinUserLotto(userLotto);
        }
        outputView.userResult(count, lottoManagementService.getAllUserLottos());

        return cost;
    }

    // 당첨 번호와 보너스 번호를 설정
    private void createLotto() {
        Lotto lotto = inputView.winningNumbers();
        lottoManagementService.joinLotto(lotto);

        int bonusNum = inputView.bonusNumber(lotto);
        lottoManagementService.setBonusNumForUsers(bonusNum);
    }

    // 당첨 통계를 계산하고 수익률을 출력
    private void createWinningStatistics(int cost) {
        Map<WinningRank, Long> winningStatics = lottoManagementService.getWinningStatistics();

        outputView.statistics(winningStatics);
        outputView.profitRate(lottoManagementService.calculateTotalPrize(winningStatics), cost);
    }

    // 당첨 번호와 유저 로또 번호를 비교하여 당첨 결과를 설정
    private void drawLottoNumbers() {
        lottoManagementService.drawLotto();
    }

}
