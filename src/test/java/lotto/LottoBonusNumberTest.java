package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lottoBonusNumber.LottoBonusNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoBonusNumberTest {
    private String lottoBonusNumber;
    private LottoBonusNumberValidator lottoBonusNumberValidator;
    List<Integer> seperatedLottoWinningNumbers;

    @BeforeEach
    void setUp() {
        lottoBonusNumberValidator = new LottoBonusNumberValidator();
        seperatedLottoWinningNumbers = Arrays.asList(1, 2, 3, 4, 5);
    }


    @DisplayName("로또 보너스 번호가 숫자 형식이 아니라면 예외가 발생한다.")
    @Test
    void 로또_보너스_번호가_숫자_형식이_아니라면_예외가_발생한다() {
        // Given&When
        lottoBonusNumber = "one thousand";

        // Then
        assertThatThrownBy(() -> lottoBonusNumberValidator.validateAllThing(lottoBonusNumber, seperatedLottoWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 보너스 번호의 범위가 1~45가 아니라면 예외가 발생한다.")
    @Test
    void 로또_보너스_번호의_범위가_1이상_45이하가_아니라면_예외가_발생한다() {
        // Given&When
        lottoBonusNumber = "65";

        // Then
        assertThatThrownBy(() -> lottoBonusNumberValidator.validateAllThing(lottoBonusNumber, seperatedLottoWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 보너스 번호가 당첨 숫자들과 겹치면 예외가 발생한다.")
    @Test
    void 로또_보너스_번호가_당첨_숫자들과_겹치면_예외가_발생한다() {
        // Given&When
        lottoBonusNumber = "5";

        // Then
        assertThatThrownBy(() -> lottoBonusNumberValidator.validateAllThing(lottoBonusNumber, seperatedLottoWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
