package lotto;


import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGeneratorTest {

    @DisplayName("로또 구입 금액이 1000원 단위로 떨어지지 않으면 예외를 발생한다.")
    @Test
    void 로또_구입금액_단위_테스트() {
        assertThatThrownBy(() -> new LottoGenerator(1500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
