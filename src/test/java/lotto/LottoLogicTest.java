package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoLogicTest {
    @DisplayName("구입 금액이 로또 가격 단위가 아니면 예외가 발생한다.")
    @Test
    void 구입_금액이_로또_가격_단위가_아니면_예외가_발생한다() {     
        assertThatThrownBy(() -> (new LottoLogic(1000)).issueLottoAsPrice(1005))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액이 로또 가격보다 작으면 예외가 발생한다.")
    @Test
    void 구입_금액이_로또_가격보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> (new LottoLogic(1000)).issueLottoAsPrice(50))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
