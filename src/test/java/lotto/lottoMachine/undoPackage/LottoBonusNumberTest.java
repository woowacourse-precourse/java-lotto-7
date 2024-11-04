package lotto.lottoMachine.undoPackage;

import java.util.Arrays;
import java.util.List;
import lotto.lottoMachine.lottoBonusNumber.LottoBonusNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBonusNumberTest {
    private String lottoBonusNumber;
    private LottoBonusNumberValidator lottoBonusNumberValidator;
    List<Integer> seperatedLottoWinningNumbers;

    @BeforeEach
    void setUp() {
        lottoBonusNumberValidator = new LottoBonusNumberValidator();
        seperatedLottoWinningNumbers = Arrays.asList(1, 2, 3, 4, 5);
    }

    @DisplayName("로또 보너스 번호가 숫자 형식이 아니라면 유효성 검사가 실패해야 한다.")
    @Test
    void 로또_보너스_번호가_숫자_형식이_아니라면_유효성_검사가_실패해야_한다() {
        // Given
        lottoBonusNumber = "one thousand";

        // When
        boolean isValid = lottoBonusNumberValidator.validateAllThing(lottoBonusNumber, seperatedLottoWinningNumbers);

        // Then
        assertThat(isValid).isFalse();
    }

    @DisplayName("로또 보너스 번호의 범위가 1~45가 아니라면 유효성 검사가 실패해야 한다.")
    @Test
    void 로또_보너스_번호의_범위가_1이상_45이하가_아니라면_유효성_검사가_실패해야_한다() {
        // Given
        lottoBonusNumber = "65";

        // When
        boolean isValid = lottoBonusNumberValidator.validateAllThing(lottoBonusNumber, seperatedLottoWinningNumbers);

        // Then
        assertThat(isValid).isFalse();
    }

    @DisplayName("로또 보너스 번호가 당첨 숫자들과 겹치면 유효성 검사가 실패해야 한다.")
    @Test
    void 로또_보너스_번호가_당첨_숫자들과_겹치면_유효성_검사가_실패해야_한다() {
        // Given
        lottoBonusNumber = "5";

        // When
        boolean isValid = lottoBonusNumberValidator.validateAllThing(lottoBonusNumber, seperatedLottoWinningNumbers);

        // Then
        assertThat(isValid).isFalse();
    }

    @DisplayName("로또 보너스 번호가 유효한 경우 유효성 검사가 성공해야 한다.")
    @Test
    void 로또_보너스_번호가_유효한_경우_유효성_검사가_성공해야_한다() {
        // Given
        lottoBonusNumber = "7"; // 1~45 범위 내 숫자이며 당첨 번호와 중복되지 않음

        // When
        boolean isValid = lottoBonusNumberValidator.validateAllThing(lottoBonusNumber, seperatedLottoWinningNumbers);

        // Then
        assertThat(isValid).isTrue();
    }
}
