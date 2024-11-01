package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    Lotto customLotto1;
    Lotto customLotto2;
    Lotto customLotto3;
    Lotto customLotto4;

    @BeforeEach
    void setUp() {
        customLotto1 = LottoFactory.createCustomLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        customLotto2 = LottoFactory.createCustomLotto(Arrays.asList(11, 12, 13, 14, 15, 16));
        customLotto3 = LottoFactory.createCustomLotto(Arrays.asList(21, 22, 23, 24, 25, 26));
        customLotto4 = LottoFactory.createCustomLotto(Arrays.asList(31, 32, 33, 34, 35, 36));
    }

    @DisplayName("Lotto 여러개를 입력받아 Lottos 객체를 생성한다.")
    @Test
    void Lotto_여러개를_입력받아_Lottos_객체를_생성한다() {
        Lottos lottos = Lottos.of(Arrays.asList(customLotto1, customLotto2, customLotto3));

        assertThat(lottos).isEqualTo(Lottos.of(Arrays.asList(customLotto1, customLotto2, customLotto3)));
    }

    @DisplayName("Lottos내 Lotto가 다르면 두 객체가 equals 하지 않다.")
    @Test
    void Lottos내_Lotto가_다르면_두_객체가_equals_하지_않다() {
        Lottos lottos1 = Lottos.of(Arrays.asList(customLotto1, customLotto2, customLotto3));
        Lottos lottos2 = Lottos.of(Arrays.asList(customLotto2, customLotto3, customLotto4));
        Lottos lottos3 = Lottos.of(Arrays.asList(customLotto2, customLotto1, customLotto3));

        assertThat(lottos1).isNotEqualTo(lottos2);
        assertThat(lottos1).isNotEqualTo(lottos3);
    }
}
