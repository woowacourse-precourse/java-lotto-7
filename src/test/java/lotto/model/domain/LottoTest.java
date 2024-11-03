package lotto.model.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("정적 팩토리 메서드 of로 Lotto 객체를 생성하는지 확인")
    void of() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = Lotto.of(numbers);

        // then
        assertThat(lotto.getNumbers().get(0)).isEqualTo(1);
        assertThat(lotto.getNumbers().get(1)).isEqualTo(2);
        assertThat(lotto.getNumbers().get(2)).isEqualTo(3);
        assertThat(lotto.getNumbers().get(3)).isEqualTo(4);
        assertThat(lotto.getNumbers().get(4)).isEqualTo(5);
        assertThat(lotto.getNumbers().get(5)).isEqualTo(6);
    }

    @Test
    @DisplayName("getNumbers 호출 시 Lotto 번호 리스트 반환하는지 확인")
    void getNumbers() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = Lotto.of(numbers);
        List<Integer> retrievedNumbers = lotto.getNumbers();

        // then
        assertThat(retrievedNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("getStringNumbers 호출 시 Lotto 번호 리스트를 문자열 리스트로 변환하여 반환하는지 확인")
    void getStringNumbers() {
        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        Lotto lotto = Lotto.of(numbers);
        List<String> retrievedStringNumbers = lotto.getStringNumbers();

        // then
        assertThat(retrievedStringNumbers).containsExactly("1", "2", "3", "4", "5", "6");
    }
}
