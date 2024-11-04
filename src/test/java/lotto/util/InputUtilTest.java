package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InputUtilTest {
    @DisplayName("로또 번호 입력이 잘못된 경우 예외가 발생한다.")
    @Test
    void 로또_번호_입력이_잘못된_경우_예외가_발생한다() {
        assertThatThrownBy(() -> InputUtil.parseInputToLottoList("1,2,,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호_파싱_테스트() {
        String input = "1,2,3,4,5,6";
        List<Integer> expectedResult = List.of(1,2,3,4,5,6);
        List<Integer> actualResult = InputUtil.parseInputToLottoList(input);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
