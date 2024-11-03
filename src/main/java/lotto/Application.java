package lotto;

import lotto.controller.LottoManagementController;
import lotto.repository.LottoRepositoryImpl;
import lotto.repository.UserLottoRepositoryImpl;
import lotto.service.LottoManagementService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoManagementController lottoManagementController = new LottoManagementController(
                new LottoManagementService(new UserLottoRepositoryImpl(), new LottoRepositoryImpl()),
                new InputView(), new OutputView()
        );

        lottoManagementController.executeLottoGame();
    }
}
