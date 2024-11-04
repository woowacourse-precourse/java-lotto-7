package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;


public class LottoTest {

    @DisplayName("유효한 로또번호 입력시 객체 성공적으로 생성")
    @Test
    void 유효한_로또번호_입력시_객체_성공적으로_생성() {
        List<Integer> validNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThatCode(() -> new Lotto(validNumbers)).doesNotThrowAnyException();
    }

    @DisplayName("로또 번호가 6개 미만이면 예외 발생")
    @Test
    void 로또_번호의_개수가_6개_미만이면_예외가_발생() {
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new Lotto(invalidNumbers)).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 번호에 1~45 범위를 벗어난 숫자가 있으면 예외 발생")
    @Test
    void 로또_번호에_범위를_벗어난_숫자가_있으면_예외_발생() {
        List<Integer> invalidNumbers = Arrays.asList(1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
    
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외 발생")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외_발생() {
        List<Integer> invalidNumbers = Arrays.asList(1,1,2,3,4,5);
        
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 중복되지 않아야 합니다.");
    }
}
