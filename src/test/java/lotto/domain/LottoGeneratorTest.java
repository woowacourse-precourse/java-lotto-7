package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    @Test
    @DisplayName("로또 생성 테스트")
    void 로또_생성_테스트() {
        MyLotto lottos = MyLotto.createLottos(3, LottoUniqueGenerator.getLottoUniqueGenerator());

        Assertions.assertThat(lottos.getNumberOfLotto()).isEqualTo(3);
    }
}
