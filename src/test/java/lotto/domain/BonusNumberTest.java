package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {

    @Test
    @DisplayName("숫자를 입력할 경우 BonusNumber 객체기 생성된다.")
    void create() {
        // given
        int number = 1;
        // when
        BonusNumber bonusNumber = new BonusNumber(number);
        // then
        assertThat(bonusNumber).isNotNull();
    }

    @Test
    @DisplayName("1미만의 숫자가 입력될 경우 예외가 발생한다.")
    void throwMinRangeException() {
        // given
        int number = 0;
        // when, then
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("45초과의 숫자가 입력될 경우 예외가 발생한다.")
    void throwMaxRangeException() {
        // given
        int number = 46;
        // when, then
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력받은 숫자와 보너스 번호가 같을 경우 true를 반환한다.")
    void isSame() {
        // given
        BonusNumber bonusNumber = new BonusNumber(1);
        int number = 1;
        // when
        boolean result = bonusNumber.isSame(number);
        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("입력받은 숫자와 보너스 번호가 다를 경우 false를 반환한다.")
    void isNotSame() {
        // given
        BonusNumber bonusNumber = new BonusNumber(1);
        int number = 2;
        // when
        boolean result = bonusNumber.isSame(number);
        // then
        assertThat(result).isFalse();
    }
}