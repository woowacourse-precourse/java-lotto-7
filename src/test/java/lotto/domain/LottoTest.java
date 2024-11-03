package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @DisplayName("로또 번호의 갯수가 6개가 아닐시 예외")
    @Test
    void lottoSizeTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 중복시 예외")
    @Test
    void lottoDuplicateNumberTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호 중 범위 밖 숫자 포함시 예외")
    @Test
    void lottoNumberRangeTest() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, -4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 생성 성공 및 정렬")
    @Test
    void lottoNumberTest() {
        Lotto lotto = new Lotto(List.of(6, 5, 4, 3, 2, 1));
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
