package lotto;

import lotto.collection.WinningNumber;
import lotto.controller.LottoController;
import lotto.controller.UserController;
import lotto.domain.LottoResult;

public class Application {
    public static void main(String[] args) {
        final UserController userController = UserController.getInstance();
        final LottoController lottoController = LottoController.getInstance();

        // 구입 금액 입력
        int userId = userController.getUserIdByInputPurchasePrice();

        // 로또 구매
        userController.getPurchaseLottoTickets(userId);

        // 당첨 번호 입력
        WinningNumber winningNumber = lottoController.getWinningNumbers();

        // 보너스 번호 입력
        LottoResult lottoResult = lottoController.getBonusNumbers(winningNumber);

        // 당첨 통계 출력
        userController.getWinningResult(lottoResult,userId);


    }
}
