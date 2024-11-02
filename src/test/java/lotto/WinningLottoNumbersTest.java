package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("당첨 번호 테스트")
public class WinningLottoNumbersTest {

    @Test
    @DisplayName("당첨 번호는 6개의 숫자여야 한다.")
    void 실패_당첨번호생성_5개() {
        // given
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5);

        // when & then
        assertThatThrownBy(() -> new WinningLottoNumbers(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 6개여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호는 1부터 45 사이의 숫자여야 한다.")
    void 실패_당첨번호_범위초과() {
        // given
        List<Integer> invalidNumbers = List.of(0, 1, 2, 3, 4, 46);

        // when & then
        assertThatThrownBy(() -> new WinningLottoNumbers(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호는 중복될 수 없다.")
    void 실패_당첨번호_중복() {
        // given
        List<Integer> invalidNumbers = List.of(1, 2, 3, 4, 5, 5);

        // when & then
        assertThatThrownBy(() -> new WinningLottoNumbers(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 번호는 중복될 수 없습니다.");
    }
}
