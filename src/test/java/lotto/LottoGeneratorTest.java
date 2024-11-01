package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @DisplayName("로또 랜덤 생성 예외 없는지 테스트")
    @Test
    void 로또_랜덤_생성_테스트() {
        final LottoGenerator lottoGenerator = new LottoGenerator();
        Assertions.assertDoesNotThrow(() -> lottoGenerator.random());
    }
}