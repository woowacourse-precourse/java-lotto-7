package lotto.service;

import lotto.domain.*;
import lotto.model.LottoCollection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoServiceTest {
    @Test
    @DisplayName("로또 서비스 테스트")
    public void judgeLottoTest() {
        assertRandomUniqueNumbersInRangeTest(() -> {
            //given
            double input = 1000;
            PurchaseAmount purchaseAmount = new PurchaseAmount(input);
            int numberOfLotto = purchaseAmount.getNumberOfLotto();
            LottoCollection lottoCollection = new LottoCollection(numberOfLotto);
            String numbers = "1,2,3,4,5,6";
            WinningNumber winningNumber = new WinningNumber(numbers);
            Bonus bonus = new Bonus("7");
            WinningLotto winningLotto = new WinningLotto(winningNumber,bonus);
            LottoService lottoService = new LottoService(purchaseAmount,lottoCollection,winningLotto);
            lottoService.judgeLotto();

            //when
            double rateOfReturn = lottoService.getRateOfReturn();

            //then
            assertEquals(rateOfReturn,200000000);
            },
                List.of(1,2,3,4,5,6)
        );
    }
}