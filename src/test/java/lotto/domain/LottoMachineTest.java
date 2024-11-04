package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import java.util.stream.Stream;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoMachineTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    @DisplayName("of - 보너스 숫자와 당첨 숫자들이 겹치는 경우에는 예외가 발생한다.")
    void validateBonusNumberDuplicate(int bonus) {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        BonusNumber bonusNumber = BonusNumber.from(bonus);
        // when & then
        assertThatThrownBy(() -> LottoMachine.of(lotto, bonusNumber))
                .isInstanceOf(LottoException.class)
                .hasMessage(ErrorMessage.INVALID_BONUS_NUMBER_DUPLICATE.getMessage());
    }

    @Test
    @DisplayName("of - 보너스 숫자와 당첨 숫자가 겹치지 않은 경우 정상적으로 LottoMachine을 생성한다.")
    void successMakeLottoMachine() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        BonusNumber bonusNumber = BonusNumber.from(7);
        // when & then
        assertDoesNotThrow(() -> LottoMachine.of(lotto, bonusNumber));
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("getLottoResult - 보너스 숫자와 당첨 숫자와 비교하여 현재 로또의 결과를 정확히 추출한다.")
    void getLottoResult(List<Integer> numbers, LottoResult expected) {
        // given
        LottoMachine lottoMachine = createLottoMachine();
        Lotto purchasedLotto = new Lotto(numbers);
        // when
        LottoResult lottoResult = lottoMachine.getLottoResult(purchasedLotto);
        // then
        assertThat(lottoResult).isEqualTo(expected);

    }

    static Stream<Arguments> getLottoResult() {
        return Stream.of(
                Arguments.of(List.of(8, 9, 10, 11, 12, 13), LottoResult.NONE),
                Arguments.of(List.of(7, 8, 9, 10, 11, 12), LottoResult.NONE),
                Arguments.of(List.of(1, 7, 8, 9, 10, 11), LottoResult.NONE),
                Arguments.of(List.of(1, 2, 7, 10, 11, 12), LottoResult.NONE),
                Arguments.of(List.of(1, 2, 3, 7, 11, 12), LottoResult.FIFTH),
                Arguments.of(List.of(1, 2, 3, 10, 11, 12), LottoResult.FIFTH),
                Arguments.of(List.of(1, 2, 3, 4, 7, 12), LottoResult.FOURTH),
                Arguments.of(List.of(1, 2, 3, 4, 7, 12), LottoResult.FOURTH),
                Arguments.of(List.of(1, 2, 3, 4, 5, 10), LottoResult.THIRD),
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), LottoResult.SECOND),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), LottoResult.FIRST)
        );
    }

    private LottoMachine createLottoMachine() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        BonusNumber bonusNumber = BonusNumber.from(7);
        return LottoMachine.of(lotto, bonusNumber);
    }
}