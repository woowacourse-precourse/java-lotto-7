package lotto.service;

import lotto.data.Database;
import lotto.data.Lotto;
import lotto.data.Result;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    private LottoMachine lottoMachine = new LottoMachine();
    private Database database;

    @DisplayName("로또를 14000원으로 14개 구매한다.")
    @Test
    void buyLottoTest() {
        // given
        Long money = 14000L;
        // when
        lottoMachine.buyLotto(money);
        // then
        assertThat(lottoMachine.getPurchasedLotto().size()).isEqualTo(14);
    }

    @DisplayName("로또 구입 결과 : 1등 1개, 2등 1개, 3등 1개, 4등 1개 당첨.")
    @Test
    void calculateResultTest() {
        // given
        database.purchaseLottoList.addAll(List.of(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 45)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9))
        ));
        // when
        lottoMachine.calculateResult(List.of(1, 2, 3, 4, 5, 6), 7);
        // then
        Result result = lottoMachine.getResult();
        assertThat(result.getSixNumberMatch()).isEqualTo(1);
        assertThat(result.getBonusNumberMatch()).isEqualTo(1);
        assertThat(result.getFiveNumberMatch()).isEqualTo(1);
        assertThat(result.getFourNumberMatch()).isEqualTo(1);
    }

    @AfterEach
    void tearDown() {
        Database.purchaseLottoList.clear();
        Database.result = new Result();
    }
}
