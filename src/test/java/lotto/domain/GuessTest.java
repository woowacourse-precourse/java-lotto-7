package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GuessTest {

    @Test
    @DisplayName("중복 숫자 입력 예외")
    void duplicateNumbers() {
        assertThatThrownBy(() -> new Guess(List.of(1,2,3,3,4,5), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 개수 초과 예외")
    void countOfNumbers() {
        assertThatThrownBy(()-> new Guess(List.of(1,2,3,4,5,6,7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("보너스 숫자 검증")
    void validateBonusNumber() {
        assertThatThrownBy(() -> new Guess(List.of(1,2,3,4,5,6), 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("생성자 검증 로직")
    void validateConstructor() {
        Guess guess = new Guess(List.of(1,2,3,4,5,6), 7);
        assertThat(guess.getLotto()).isEqualTo(List.of(1,2,3,4,5,6));
        assertThat(guess.getBonusNumber()).isEqualTo(7);
    }
}
