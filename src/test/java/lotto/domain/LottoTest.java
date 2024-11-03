package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @DisplayName("로또 생성 성공")
    @Test
    void createLottoSuccessTest() {
        List<Integer> numbers = Arrays.asList(8, 21, 23, 41, 42, 43);
        Lotto lotto = new Lotto(numbers);
        assertThat(lotto.getNumbers()).containsExactly(8, 21, 23, 41, 42, 43);
    }

    @DisplayName("로또 번호 6개 미만 예외")
    @Test
    void lottoNumberCountUnderSix() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 6개여야 합니다.");
    }
}
