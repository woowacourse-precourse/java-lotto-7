package global.utils;

import static global.utils.GlobalUtil.BonusNumberUtil.parsingBonusNumber;
import static global.utils.GlobalUtil.LottoUtil.sortingNumbers;
import static global.utils.GlobalUtil.PrizeUtil.applyPrizeFormat;
import static global.utils.GlobalUtil.PurchaseAmountUtil.parsingPurchaseAmount;
import static global.utils.GlobalUtil.WeeklyNumberUtil.parsingWeeklyNumbers;
import static global.utils.GlobalUtil.WeeklyNumberUtil.splitWeeklyNumberWithSeparator;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import global.exception.ErrorCode;
import global.utils.GlobalUtil.PurchaseAmountUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GlobalUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"100", "20000", "50000000000"})
    @DisplayName("입력한 숫자를 BigInteger 형태의 값으로 변환할 수 있다")
    void t001(String input) {
        BigInteger defaultValue = new BigInteger(input);
        BigInteger testValue = parsingPurchaseAmount(input);

        assertThat(testValue).isEqualTo(defaultValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"100L", "A20000", "50000000%"})
    @DisplayName("변환할 구매 금액이 올바르지 않으면, NumberFormatException 이 발생한다. ")
    void t002(String input) {
        assertThatThrownBy(() -> parsingPurchaseAmount(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining(ErrorCode.INPUT_SHOULD_BE_PARSING.getMsg());
    }

    @Test
    @DisplayName("정렬되지 않은 리스트의 정렬을 할 수 있다")
    void t003() {
        List<Integer> before = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
        List<Integer> after = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        List<Integer> sortingReslt = sortingNumbers(before);

        assertThat(after).isEqualTo(sortingReslt);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "5,6,7,8,9,10", "11,12,13,14,15,16"})
    @DisplayName("쉼표로 구분된 당첨 번호가 입력되면, 이를 리스트로 나눌 수 있다")
    void t004(String input) {
        List<String> expectedResult = new ArrayList<>(List.of(input.split(",")));

        List<String> splitResult = splitWeeklyNumberWithSeparator(input);

        assertThat(splitResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("String 형 번호 리스트를 변환하여 Integer 형 번호 리스트로 반환할 수 있다")
    void t005() {
        List<String> before = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
        List<Integer> expectedAfter = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Integer> parsingResult = parsingWeeklyNumbers(before);

        assertThat(parsingResult).isEqualTo(expectedAfter);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("보너스 번호가 주어지면, 이를 int 형으로 반환해줄 수 있다")
    void t006(String input) {
        int expectedResult = Integer.parseInt(input);

        int result = parsingBonusNumber(input);

        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1%", "A2", "_3"})
    @DisplayName("변환할 보너스 번호가 올바르지 않으면, NumberFormatException 이 발생한다")
    void t007(String input) {
        assertThatThrownBy(() -> parsingBonusNumber(input))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining(ErrorCode.INPUT_SHOULD_BE_PARSING.getMsg());
    }

    @Test
    @DisplayName("int형 상금이 주어지면, 이를 천 단위마다 소수점을 붙인 형태로 변환할 수 있다")
    void t008() {
        int before = 10000000;
        String expectedValue = "10,000,000";

        String result = applyPrizeFormat(before);

        assertThat(result).isEqualTo(expectedValue);
    }

}