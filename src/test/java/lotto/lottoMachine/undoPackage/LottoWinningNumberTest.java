package lotto.lottoMachine.undoPackage;

import java.util.Arrays;
import java.util.List;
import lotto.lottoMachine.lottoWinningNumber.LottoWinningNumberDelimiter;
import lotto.lottoMachine.lottoWinningNumber.LottoWinningNumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningNumberTest {
    private String lottoWinningNumber;
    private LottoWinningNumberDelimiter lottoWinningNumberDelimiter;
    private LottoWinningNumberValidator lottoWinningNumberValidator;

    @BeforeEach
    void setUp() {
        lottoWinningNumberDelimiter = new LottoWinningNumberDelimiter();
        lottoWinningNumberValidator = new LottoWinningNumberValidator();
    }

    @DisplayName("로또 당첨 번호들의 개수가 6개가 아니라면 유효성 검사가 실패해야 한다.")
    @Test
    void 로또_당첨_번호들의_개수가_6개가_아니라면_유효성_검사가_실패해야_한다() {
        // Given
        lottoWinningNumber = "1,2,3";
        List<String> seperatedLottoWinningNumbers = lottoWinningNumberDelimiter.getSeperatedLottoWinningNumbers(lottoWinningNumber);

        // When
        boolean isValid = lottoWinningNumberValidator.validateAllThing(seperatedLottoWinningNumbers);

        // Then
        assertThat(isValid).isFalse();
    }

    @DisplayName("로또 당첨 번호들 중 겹치는 것이 있다면 유효성 검사가 실패해야 한다.")
    @Test
    void 로또_당첨_번호들_중_겹치는_것이_있다면_유효성_검사가_실패해야_한다() {
        // Given
        lottoWinningNumber = "1,1,2,3,4,5";
        List<String> seperatedLottoWinningNumbers = lottoWinningNumberDelimiter.getSeperatedLottoWinningNumbers(lottoWinningNumber);

        // When
        boolean isValid = lottoWinningNumberValidator.validateAllThing(seperatedLottoWinningNumbers);

        // Then
        assertThat(isValid).isFalse();
    }

    @DisplayName("로또 당첨 번호들이 숫자 형식이 아니라면 유효성 검사가 실패해야 한다.")
    @Test
    void 로또_당첨_번호들이_숫자_형식이_아니라면_유효성_검사가_실패해야_한다() {
        // Given
        lottoWinningNumber = "1,2,3,a,5,6";
        List<String> seperatedLottoWinningNumbers = lottoWinningNumberDelimiter.getSeperatedLottoWinningNumbers(lottoWinningNumber);

        // When
        boolean isValid = lottoWinningNumberValidator.validateAllThing(seperatedLottoWinningNumbers);

        // Then
        assertThat(isValid).isFalse();
    }

    @DisplayName("로또 당첨 번호들의 범위가 1~45가 아니라면 유효성 검사가 실패해야 한다.")
    @Test
    void 로또_당첨_번호들의_범위가_1이상_45이하가_아니라면_유효성_검사가_실패해야_한다() {
        // Given
        lottoWinningNumber = "1,24,25,66,74,21";
        List<String> seperatedLottoWinningNumbers = lottoWinningNumberDelimiter.getSeperatedLottoWinningNumbers(lottoWinningNumber);

        // When
        boolean isValid = lottoWinningNumberValidator.validateAllThing(seperatedLottoWinningNumbers);

        // Then
        assertThat(isValid).isFalse();
    }

    @DisplayName("로또 당첨 번호를 쉼표 기준으로 구분하고 숫자로 변환한다.")
    @Test
    void 로또_당첨_번호를_쉼표_기준으로_구분하고_숫자로_변환한다() {
        // Given
        lottoWinningNumber = "1,2,3,4,5,6";
        List<String> seperatedLottoWinningNumbers = lottoWinningNumberDelimiter.getSeperatedLottoWinningNumbers(lottoWinningNumber);

        // When
        List<Integer> seperatedLottoWinningNumbersToInt = lottoWinningNumberValidator.convertToCompareNumbers(seperatedLottoWinningNumbers);

        // Then
        Assertions.assertEquals(seperatedLottoWinningNumbersToInt, Arrays.asList(1, 2, 3, 4, 5, 6));
    }
}
