package lotto.application.ticket.domain.payment.lottoQuantity;

import lotto.application.ticket.domain.payment.LottoQuantity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("LottoQuantity - 생성")
public class CreateTest {

    @DisplayName("유효 수량으로 생성 성공")
    @ParameterizedTest
    @ValueSource(ints = {1, 50, 100})
    void 유효한_수량으로_생성성공(int count) {

        // expect
        Assertions.assertThatCode(() -> LottoQuantity.of(count))
                .doesNotThrowAnyException();
    }

    @DisplayName("최소 수량(1개)으로 생성 성공")
    @Test
    void 최소수량_생성성공() {
        // given
        LottoQuantity quantity = LottoQuantity.of(1);

        // expect
        Assertions.assertThat(quantity.getValue()).isEqualTo(1);
    }

    @DisplayName("최대 수량(100개)으로 생성 성공")
    @Test
    void 최대수량_생성성공() {
        // given
        LottoQuantity quantity = LottoQuantity.of(100);

        // expect
        Assertions.assertThat(quantity.getValue()).isEqualTo(100);
    }

    @DisplayName("최소 수량보다 작은 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -5})
    void 최소수량보다_작으면_생성실패(int count) {

        // expect
        Assertions.assertThatThrownBy(() -> LottoQuantity.of(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 수량은 1개 이상이어야 합니다.");
    }

    @DisplayName("최대 수량보다 큰 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(ints = {101, 150, 200})
    void 최대수량보다_크면_생성실패(int count) {

        // expect
        Assertions.assertThatThrownBy(() -> LottoQuantity.of(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 수량은 100개를 초과할 수 없습니다.");
    }

}
