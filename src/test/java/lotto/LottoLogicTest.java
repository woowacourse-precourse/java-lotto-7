package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @DisplayName("당첨 번호의 범위가 1~45를 만족하지 않으면 예외가 발생한다.")
    @Test
    void 당첨_번호의_범위가_1과_45_사이를_만족하지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> (new LottoLogic(1000)).validateWinningNumber(List.of(0, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("보너스 번호의 범위가 1~45를 만족하지 않으면 예외가 발생한다.")
    @Test
    void 보너스_번호의_범위가_1과_45_사이를_만족하지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> (new LottoLogic(1000)).validateBonusNumber(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨 번호에 중복이 있으면 예외가 발생한다.")
    @Test
    void 당첨_번호에_중복이_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> (new LottoLogic(1000)).validateWinningNumber(List.of(1, 1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
