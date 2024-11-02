package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = WinningLotto.create("1,2,3,4,5,6");
    }

    @Test
    @DisplayName("WinningLotto 객체 생성 테스트")
    void createWinningLottoTest() {
        assertThat(winningLotto.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "1,2,3", "1,2,3,4,5,abc", "1,1,2,3,4,5"})
    @DisplayName("WinningLotto 생성 시 예외 테스트")
    void createWinningLotto_invalidInput(String input) {
        assertThatThrownBy(() -> WinningLotto.create(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
