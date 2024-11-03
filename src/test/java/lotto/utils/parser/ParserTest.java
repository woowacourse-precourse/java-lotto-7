package lotto.utils.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParserTest {

    @Test
    @DisplayName("로또 번호 문자열을 정수 리스트로 변환해야 한다")
    void 로또_번호_문자열_정수_리스트_변환() {
        //given
        String winningNumbers = "1,2,3,4,5";

        //when
        List<Integer> result = Parser.parsingNumbers(winningNumbers);

        //then
        assertThat(result).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    @DisplayName("유효하지 않은 로또 번호 예외 검증")
    void 로또_번호_예외_검증() {
        //given
        String invalidWinningNumbers = "1,2,a,4,5";

        //when
        try {
            Parser.parsingNumbers(invalidWinningNumbers);
        } catch (LottoException e) {
            assertThat("[ERROR] 당첨 번호는 숫자를 입력하셔야 합니다.").isEqualTo(e.getMessage());
        }

        //then
        assertThatThrownBy(() -> Parser.parsingNumbers(invalidWinningNumbers))
                .isInstanceOf(LottoException.class)
                .hasMessage(ErrorMessage.WINNING_LOTTO_IS_NOT_NUMBER.getErrorMessage());
    }

    @Test
    @DisplayName("구매 금액 문자열을 정수로 변환")
    void 문자열_정수_변환_정상() {
        //given
        String purchaseAmount = "1000";

        //when
        int result = Parser.parsingPurchaseAmount(purchaseAmount);

        //then
        assertThat(result).isEqualTo(1000);
    }

    @Test
    @DisplayName("유효하지 않은 구매 금액 예외 검증")
    void 구매_금액_예외_검증() {
        //given
        String invalidPurchaseAmount = "invalid";

        //when
        try {
            Parser.parsingPurchaseAmount(invalidPurchaseAmount);
        } catch (LottoException e) {
            assertThat("[ERROR] 구입 금액은 숫자만 입력하셔야 합니다.").isEqualTo(e.getMessage());
        }

        //then
        assertThatThrownBy(() -> Parser.parsingPurchaseAmount(invalidPurchaseAmount))
                .isInstanceOf(LottoException.class)
                .hasMessage(ErrorMessage.LOTTO_PURCHASE_IS_NOT_NUMBER.getErrorMessage());
    }

    @Test
    @DisplayName("보너스 번호 문자열을 정수로 변환")
    void 보너스_번호_정수_변환_정상() {
        //given
        String bonusNumber = "7";

        //when
        int result = Parser.parsingBonusNumber(bonusNumber);

        //then
        assertThat(result).isEqualTo(7);
    }

    @Test
    @DisplayName("유효하지 않은 보너스 번호 예외 검증")
    void 보너스_번호_예외_검증() {
        //given
        String invalidBonusNumber = "invalid";

        //when
        try {
            Parser.parsingBonusNumber(invalidBonusNumber);
        } catch (LottoException e) {
            assertThat("[ERROR] 보너스 번호는 숫자를 입력하셔야 합니다").isEqualTo(e.getMessage());
        }

        //then
        assertThatThrownBy(() -> Parser.parsingBonusNumber(invalidBonusNumber))
                .isInstanceOf(LottoException.class)
                .hasMessage(ErrorMessage.BONUS_NUMBER_IS_NOT_NUMBER.getErrorMessage());
    }

    @Test
    @DisplayName("통계 결과 문자열 변환")
    void 통계_결과_문자열_변환() {
        //given
        List<Integer> result = List.of(1, 2, 3, 4, 5);
        double profit = 150.5;

        //when
        List<String> convertedResult = Parser.parsingResult(result, profit);

        //then
        assertThat(convertedResult).containsExactly("1", "2", "3", "4", "5", "150.5");
    }


}
