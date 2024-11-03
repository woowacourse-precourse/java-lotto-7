package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPurchaseTest {

    private static final long LOTTO_PRICE = 1_000L;

    @ParameterizedTest
    @ValueSource(strings = {"3000", "3500"})
    void 구입_금액을_로또_금액으로_나눈_몫만큼_로또를_발행한다(String price) {
        //when
        LottoPurchase lottoPurchase = LottoPurchase.from(price);

        //then
        Assertions.assertThat(lottoPurchase.getLottoCount()).isEqualTo(Long.parseLong(price) / LOTTO_PRICE);
    }

    @Test
    void 구입_금액이_로또_금액보다_적을_떄_예외가_발생한다() {
        //given
        String price = "900";

        //when & then
        Assertions.assertThatThrownBy(() -> LottoPurchase.from(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(" 금액은 최소 " + LOTTO_PRICE + "원 이상이어야 합니다.");
    }
}
