package lotto.domain;

import lotto.service.LottoService;
import lotto.util.Parse;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

class LottoGameTest {

    @Test
    @DisplayName("금액만큼 로또가 만들어지는지 테스트")
    void lottoGameConstructTest(){
        Integer money = 100000;

        LottoGame lottoGame = LottoGame.of(money);

        Assertions.assertThat(lottoGame.getLottos().size()).isEqualTo(money/1000);
    }
}