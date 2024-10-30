package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    private LottoGenerator lotto;

    @Test
    @DisplayName("6개의 로또 번호를 랜덤으로 생성하는 기능 확인")
    void 로또_번호_생성_테스트() {
        lotto = new LottoGenerator();
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }
}