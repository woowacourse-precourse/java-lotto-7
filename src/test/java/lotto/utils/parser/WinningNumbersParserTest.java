package lotto.utils.parser;

import static lotto.constants.ErrorMessage.ONLY_INTEGER_RANGE_WINNING_NUMBERS_ALLOWED;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.dto.LottoNumbers;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersParserTest {

    @DisplayName("사용자 입력을 올바르게 파싱하여 Lotto 객체로 반환하는지 확인한다.")
    @Test
    void Given_UserWinningNumbersString_When_GetWinningNumbers_Then_ReturnLottoObjectWithCorrectNumbers() {
        // Given
        String userWinningNumbers = "1,2,3,4,5,6";
        List<Integer> expectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // When
        Lotto lotto = WinningNumbersParser.getWinningNumbers(userWinningNumbers);
        LottoNumbers lottoNumbers = lotto.getLottoNumbers();
        // Then
        assertThat(lottoNumbers.getLottoNumbers()).isEqualTo(expectedNumbers);
    }

    @DisplayName("정수 범위가 아닌 숫자를 입력한 경우, 예외가 발생한다.")
    @Test
    void Given_UserWinningNumbersString_When_GetWinningNumbers_Then_Error() {
        String userWinningNumbers = "1,2147483648,3,4,5,6";

        assertThatThrownBy(() -> WinningNumbersParser.getWinningNumbers(userWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ONLY_INTEGER_RANGE_WINNING_NUMBERS_ALLOWED.getMessage());
    }
}