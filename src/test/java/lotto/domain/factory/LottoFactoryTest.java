package lotto.domain.factory;

import static lotto.common.constant.ErrorMessages.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.entity.Lotto;

class LottoFactoryTest {

    @Test
    @DisplayName("로또 번호들을 자동으로 생성할 수 있다.")
    void lottoNumbersShouldGenerateItself() {
        Lotto lotto = LottoFactory.createAutoLotto();
        String lottoString = lotto.toString();
        assertThat(lottoString)
            .startsWith("[")
            .endsWith("]")
            .contains(", ")
            .matches("\\[\\d+(?:,\\s\\d+){5}\\]");
    }

    @Test
    @DisplayName("문자열로 로또를 생성한다")
    void WinningLottoShouldBeValidOnBlank() {
        String input = "1,2,3,4,5,6";
        Lotto lotto = new Lotto(input);
        String lottoString = lotto.toString();
        assertThat(lottoString).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
