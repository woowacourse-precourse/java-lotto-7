package lotto.utils.parser;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
        String userWinningNumbers = "1, 2, 3, 4, 5, 6";
        List<Integer> expectedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // When
        Lotto lotto = WinningNumbersParser.getWinningNumbers(userWinningNumbers);
        LottoNumbers lottoNumbers = lotto.getLottoNumbers();
        // Then
        assertThat(lottoNumbers.getLottoNumbers()).isEqualTo(expectedNumbers);
    }
}