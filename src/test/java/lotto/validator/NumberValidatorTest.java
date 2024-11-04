package lotto.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberValidatorTest {
    private NumbersValidator numbersValidator;

    @BeforeEach
    void setUp() {
        numbersValidator = new NumbersValidator();
    }

    @Test
    @DisplayName("번호에 공백이 포함되었는지 확인")
    void 로또_번호_공백_테스트() {
        assertThatThrownBy(() -> {
            numbersValidator.validateWinningNumbers("1, 2, 3, 4, 5");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("\n[ERROR] 로또 번호에 공백을 허용하지 않습니다.");
    }

    @Test
    @DisplayName("로또 번호가 숫자인지 확인")
    void 로또_번호_숫자_테스트() {
        assertThatThrownBy(() -> {
            numbersValidator.validateWinningNumbers("!,3,@,@,:,!");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("\n[ERROR] 로또 번호은(는) 숫자 형식이어야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호가 6개인지 확인")
    void 당첨_번호_개수_테스트() {
        assertThatThrownBy(() -> {
            numbersValidator.validateWinningNumbers("1,2,3");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("\n[ERROR] 당첨 번호는 6개이어야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 1개인지 확인")
    void 보너스_번호_개수_테스트() {
        assertThatThrownBy(() -> {
            numbersValidator.validateBonusNumber("7,8");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("\n[ERROR] 보너스 번호는 1개이어야 합니다.");
    }

    @Test
    @DisplayName("당첨 번호가 중복되었는지 확인")
    void 로또_번호_중복_테스트() {
        assertThatThrownBy(() -> {
            numbersValidator.validateWinningNumbers("1,1,1,1,1,1");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("\n[ERROR] 로또 번호가 중복되었습니다.");
    }

    @Test
    @DisplayName("로또 번호가 1 ~ 45 사이인지 확인하는 함수")
    void 로또_번호_범위_테스트() {
        assertThatThrownBy(() -> {
            numbersValidator.validateWinningNumbers("-2,1,3,4,50,60");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("\n[ERROR] 로또 번호는 1 ~ 45 사이 숫자이어야 합니다.");
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호랑 중복되는지 확인")
    void 보너스_번호_중복_테스트() {
        assertThatThrownBy(() -> {
            numbersValidator.validateWinningNumbers("1,2,3,4,5,6");
            numbersValidator.validateBonusNumber("1");
        }).isInstanceOf(IllegalArgumentException.class).hasMessage("\n[ERROR] 로또 번호가 중복되었습니다.");
    }
}
