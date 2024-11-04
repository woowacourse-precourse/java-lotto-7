package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.model.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {

    @DisplayName("올바른 형식의 입력후 객체 생성")
    @Test
    void 올바른_형식의_입력_후_객체_생성() {
        //given
        //when
        BonusNumber bonusNumber = new BonusNumber(7, List.of(1, 2, 3, 4, 5, 6));
        //then
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("숫자 범위를 벗어난 보너스 번호 입력 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 숫자_범위를_벗어난_보너스_번호_입력_테스트(int number) {
        //given
        //when & then
        assertThatThrownBy(() -> new BonusNumber(number, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 숫자는 1 이상 45 이하입니다.");
    }

    @DisplayName("당첨번호와 중복된 번호를 입력받았을 경우 테스트")
    @Test
    void 당첨번호와_중복된_번호를_입력받았을_경우_테스트() {
        //given
        //when & then
        assertThatThrownBy(() -> new BonusNumber(1, List.of(1, 2, 3, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("보너스 번호는 당첨 번호에 없는 번호이어야합니다.");
    }

}
