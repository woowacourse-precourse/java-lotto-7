package lotto.domain;

import lotto.domain.message.LottoErrorMessage;
import lotto.domain.rule.LottoRules;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    // 로또 번호 유효성 검증 테스트
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    @Test
    void ThrowExceptionWhenLottoNumberCountOverSix() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.INVALID_LOTTO_COUNT.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void ThrowExceptionWhenDuplicateLottoNumbersExist() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
    }

    @DisplayName("로또 번호에 1~45 이외의 숫자가 있으면 예외가 발생한다.")
    @Test
    void throwsExceptionIfLottoNumberIsOutOfRange() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 51)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.INVALID_LOTTO_NUMBER_IN_RANGE.getMessage());

    }

    // 랜덤값으로 구성된 로또 생성을 위한 정적팩토리 메서드 - createRandomLotto()테스트
    @DisplayName("createRandomLotto() 메서드는 6개의 숫자를 생성해야 한다")
    @Test
    void createRandomLottoGeneratesSixNumbers() {
        Lotto lotto = Lotto.createRandomLotto();
        List<Integer> numbers = lotto.getNumbers();
        assertThat(numbers).hasSize(LottoRules.NUMBER_COUNT.getValue());
    }


    @DisplayName("createRandomLotto() 메서드는 1~45 사이의 숫자를 생성해야 한다")
    @Test
    void createRandomLottoGeneratesNumbersWithinRange() {
        Lotto lotto = Lotto.createRandomLotto();
        List<Integer> numbers = lotto.getNumbers();
        assertThat(numbers).allMatch(number ->
                number >= LottoRules.MIN_NUMBER.getValue() && number <= LottoRules.MAX_NUMBER.getValue()
        );
    }

    @DisplayName("createRandomLotto() 메서드는 고유한 숫자를 생성해야 한다")
    @Test
    void createRandomLottoGeneratesUniqueNumbers() {
        Lotto lotto = Lotto.createRandomLotto();
        List<Integer> numbers = lotto.getNumbers();
        assertThat(numbers).doesNotHaveDuplicates();
    }
}
