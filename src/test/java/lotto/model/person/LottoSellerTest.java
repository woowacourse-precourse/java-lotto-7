package lotto.model.person;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoSellerTest {
    private final LottoSeller lottoSeller = new LottoSeller();

    @ParameterizedTest
    @ValueSource(ints = {-100, 0, 1500, 300})
    @DisplayName("금액 오류 테스트")
    void invalidInputAmount(final int input) {
        assertThatThrownBy(() -> lottoSeller.sellTo(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
