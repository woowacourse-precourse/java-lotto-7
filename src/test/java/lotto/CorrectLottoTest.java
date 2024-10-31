package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("당첨번호 및 보너스번호 테스트")
class CorrectLottoTest {

    @Test
    void 당첨번호와_보너스번호가_중복되는_경우() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        int bonusNumber = 6;
        assertThatThrownBy(() -> new CorrectLotto(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호와 정답 번호는 중복될 수 없습니다.");
    }
}