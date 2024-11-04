package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BonusTest {

    @Test
    @DisplayName("보너스 금액 - 성공 테스트")
    void testValidBonusNumber() {
        //given
        String input = "7";
        List<Integer> lottos = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            lottos.add(i);
        }
        Lotto winningLotto = new Lotto(lottos);

        //when
        Bonus bonus = Bonus.of(input, winningLotto);

        //then
        assertThat(bonus.getNumber()).isEqualTo(7);
    }

    @ParameterizedTest(name = "입력: ''{0}'', 메시지: {1}")
    @MethodSource("provideInvalidBonusNumber")
    @DisplayName("보너스 금액 - 실패 테스트")
    void testInvalidBonusNumber(String input, String errorMessage) {
        assertThatThrownBy(() -> Bonus.of(input, new Lotto(List.of(1, 2, 3, 4, 5, 6))))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(errorMessage);
    }

    private static Stream<Arguments> provideInvalidBonusNumber() {
        return Stream.of(
                Arguments.of("", ErrorMessage.BLANK_BONUS_NUMBER.getMessage()),
                Arguments.of("a", ErrorMessage.NOT_NUMERIC_BONUS_NUMBER.getMessage()),
                Arguments.of("100000000000000", ErrorMessage.TOO_BIG_INPUT.getMessage()),
                Arguments.of("100", ErrorMessage.OUT_RANGE_BONUS_NUMBER.getMessage()),
                Arguments.of("1", ErrorMessage.DUPLICATED_BONUS_NUMBER.getMessage())
        );
    }
}