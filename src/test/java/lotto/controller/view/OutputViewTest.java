package lotto.controller.view;

import static org.junit.jupiter.api.Assertions.*;

import lotto.controller.LottoPolicy;
import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoGameManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    @DisplayName("생성한 로또번호를 출력한다.")
    @Test
    void printLotteries() {
        //given
        LottoGameManager lottoGameManager = new LottoGameManager();
        Lotteries lotteries = lottoGameManager.initLottery(new LottoPolicy(), 5);
        OutputView outputView = new OutputView();
        //when
        outputView.printLotteries(5, lotteries);

        //then

    }

}