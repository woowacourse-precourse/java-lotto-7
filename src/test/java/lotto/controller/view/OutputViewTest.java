package lotto.controller.view;

import lotto.controller.LottoPolicy;
import lotto.domain.lottery.Lotteries;
import lotto.domain.gameManager.LottoGameManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @DisplayName("생성한 로또번호를 출력한다.")
    @Test
    void printLotteries() {
        //given
        LottoGameManager lottoGameManager = new LottoGameManager();
        Lotteries lotteries = lottoGameManager.initLottery(new LottoPolicy(), 5000);
        OutputView outputView = new OutputView();
        //when
        outputView.printLotteries(lotteries);

        //then

    }

}