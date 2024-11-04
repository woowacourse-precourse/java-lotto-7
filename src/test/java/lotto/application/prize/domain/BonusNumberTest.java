package lotto.application.prize.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.application.ticket.domain.ticket.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("BonusNumber 테스트")
class BonusNumberTest {

    @DisplayName("보너스 번호 생성 성공")
    @Test
    void 보너스_번호_생성_성공() {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        int inputBonusNum = 7;

        // when
        BonusNumber bonusNumber = BonusNumber.of(inputBonusNum, lotto);

        // then
        Assertions.assertThat(bonusNumber.getValue()).isEqualTo(inputBonusNum);
    }

    @DisplayName("범위를 벗어난 보너스 번호 생성시 예외 발생")
    @Test
    void 범위_벗어난_보너스번호_생성시_예외발생() {
        // given현
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));

        // expect
        assertThatThrownBy(() -> BonusNumber.of(46, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호와 중복된 보너스 번호 생성시 예외 발생")
    @Test
    void 당첨번호와_중복된_보너스번호_생성시_예외발생() {
        // given
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));

        // expect
        assertThatThrownBy(() -> BonusNumber.of(1, lotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

}
