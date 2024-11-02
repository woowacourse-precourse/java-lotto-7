package lotto.parse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.constant.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputParserTest {

    private InputParser inputParser;

    @BeforeEach
    void init() {
        this.inputParser = new InputParser();
    }

    @Test
    void parsePurchaseAmount_입력으로_들어온_구매금액을_성공적으로_Long으로_파싱한다() {
        // given
        String purchaseAmount = "12341234";

        // when
        Long result = inputParser.parsePurchaseAmount(purchaseAmount);

        // then
        assertThat(String.valueOf(result)).isEqualTo(purchaseAmount);
    }

    @Test
    void parsePurchaseAmount_구매금액에_문자가_있으면_실패한다() {
        // given
        String purchaseAmount = "문자123";

        // when

        // then
        assertThatThrownBy(() -> inputParser.parsePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.PURCHASE_AMOUNT_MUST_LONG);
    }

    @Test
    void parsePurchaseAmount_구매금액이_Long타입의_범위를_벗어나면_실패한다() {
        // given
        String purchaseAmount = "122312123131211213121321231231321231231231231321231";

        // when

        // then
        assertThatThrownBy(() -> inputParser.parsePurchaseAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.PURCHASE_AMOUNT_MUST_LONG);
    }

    @Test
    void parseWinnerNumber_입력으로_들어온_당첨번호를_성공적으로_Integer_List로_파싱한다() {
        // given
        String winnerNumberInput = "1,2,10,100,1000,-10000";

        // when
        List<Integer> result = inputParser.parseWinnerNumber(winnerNumberInput);

        // then
        assertThat(result).isEqualTo(List.of(1, 2, 10, 100, 1000, -10000));
    }

    @Test
    void parseWinnerNumber_빈_문자열로_인해_실패한다() {
        // given
        String winnerNumberInput = "1,2,10,,1000,-10000";

        // when

        // then
        assertThatThrownBy(() -> inputParser.parseWinnerNumber(winnerNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.WINNER_NUMBER_INVALID_COMMA_POSITION);
    }

    @Test
    void parseWinnerNumber_변환_할_수_없는_소수로_인해_실패한다() {
        // given
        String winnerNumberInput = "1,2,10,10.2,1000,-10000";

        // when

        // then
        assertThatThrownBy(() -> inputParser.parseWinnerNumber(winnerNumberInput))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.WINNER_NUMBER_INVALID_COMMA_POSITION);
    }

    @Test
    void parseBonusAmount_입력으로_들어온_보너스_번호를_성공적으로_Integer로_파싱한다() {
        // given
        String input = "7";

        // when
        Integer bonusNumber = inputParser.parseBonusAmount(input);

        // then
        assertThat(String.valueOf(bonusNumber)).isEqualTo(input);
    }

    @Test
    void parseBonusAmount_보너스번호에_문자가_있으면_실패한다() {
        // given
        String bonusNumber = "문자123";

        // when

        // then
        assertThatThrownBy(() -> inputParser.parseBonusAmount(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.BONUS_NUMBER_MUST_INTEGER);
    }

    @Test
    void parseBonusAmount_구매금액이_Integer타입의_범위를_벗어나면_실패한다() {
        // given
        String purchaseAmount = "123123213321";

        // when

        // then
        assertThatThrownBy(() -> inputParser.parseBonusAmount(purchaseAmount))
                .isInstanceOf(IllegalArgumentException.class)
                .extracting(Throwable::getMessage)
                .isEqualTo(ExceptionMessage.BONUS_NUMBER_MUST_INTEGER);
    }
}