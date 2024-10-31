package lotto;

import lotto.buyer.domain.Money;
import lotto.buyer.infrastructure.Won;
import lotto.constant.ErrorMessage;
import lotto.lotto.domain.Lotto;
import lotto.lotto.validator.LottoValidator;
import lotto.lotto.winning.domain.BonusNumber;
import lotto.lotto.winning.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    @DisplayName("1 ~ 45까지 범위의 숫자가 아닌경우 예외가 발생한다")
    void withinRangeLottoNumberTest() {
        List<List<Integer>> numbersInfo = List.of(List.of(1,2,3,4,5,46), List.of(0,1,2,3,4,5));
        numbersInfo.forEach((numbers) -> {
            assertThatThrownBy(() -> new Lotto(numbers)).isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ErrorMessage.WITHIN_RANGE.getMessage());
        });
    }
}
