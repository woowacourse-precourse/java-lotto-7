package lotto.model;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 번호는 6개여야 한다.")
    @Test
    void validate_test() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5))) // 5개
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개여야 합니다.");
    }

    @DisplayName("로또 번호가 6개일 경우 정상적으로 생성된다.")
    @Test
    void create_Lotto() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 유효한 6개 숫자
        List<Integer> numbers = lotto.getNumbers();

        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
