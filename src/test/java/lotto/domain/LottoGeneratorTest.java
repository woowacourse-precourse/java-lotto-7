package lotto.domain;


import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {

    LottoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator(new RandomNumberGenerator(1, 45), 1000L);
    }

    @ParameterizedTest
    @ValueSource(longs = {1000L, 2000L, 3000L})
    @DisplayName("로또 구입 성공")
    void purchaseLottoSuccess(Long purchasePrice) {
        assertThatCode(() -> lottoGenerator.purchaseLotto(purchasePrice));
    }

    @ParameterizedTest
    @ValueSource(longs = {1500L, 2500L, 3500L})
    @DisplayName("잘못된 단위의 로또 구입 금액")
    void purchaseLottoWithInvalidPrice(Long purchasePrice) {
        assertThatThrownBy(() -> lottoGenerator.purchaseLotto(purchasePrice))
                .isInstanceOf(IllegalArgumentException.class);
    }
}