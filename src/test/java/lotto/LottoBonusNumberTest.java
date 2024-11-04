package lotto;

import lotto.model.lotto.Lotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoBonusNumberTest {

    @Test
    void 보너스번호가_당첨번호와_중복될_경우_예외발생() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 기존 당첨 번호

        int duplicateBonusNumber = 3; // 당첨 번호에 포함된 숫자
        assertThatThrownBy(() -> {
            if (!lotto.isBonusNumberValid(duplicateBonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @Test
    void 보너스번호가_당첨번호와_중복되지_않을_경우_정상입력() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 기존 당첨 번호

        int validBonusNumber = 7; // 당첨 번호에 포함되지 않은 숫자
        assertThat(lotto.isBonusNumberValid(validBonusNumber)).isTrue();
    }
}
