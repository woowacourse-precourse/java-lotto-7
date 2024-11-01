package lotto.domain.lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class LottoFactoryTest {
    @RepeatedTest(10)
    @DisplayName("랜덤_번호를_뽑아_여러번_로또를_생성해도_예외가_발생하지_않는다.")
    public void 랜덤_번호를_뽑아_여러번_로또를_생성해도_예외가_발생하지_않는다() {
        Assertions.assertDoesNotThrow(LottoFactory::createRandomLotto);
    }
}
