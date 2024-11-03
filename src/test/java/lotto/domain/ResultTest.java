package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.domain.Result.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @DisplayName("당첨 번호 5개와 보너스 번호가 일치할 때 결과가 잘 반영되는지 확인")
    @Test
    void fiveWithBonusSuccessTest() {
        // given
        int matchingNumber = 5;
        boolean bonus = true;
        int before = getResult(matchingNumber, bonus);

        // when
        update(matchingNumber, bonus);

        // then
        int after = getResult(matchingNumber, bonus);
        assertThat(after).isEqualTo(before + 1);
    }

    @DisplayName("당첨 번호 6개가 일치하는 경우")
    @Test
    void sixSuccessTest() {
        // given
        int matchingNumber = 6;
        boolean bonus = false;
        int before = getResult(matchingNumber, bonus);

        // when
        update(matchingNumber, bonus);

        // then
        int after = getResult(matchingNumber, bonus);
        assertThat(after).isEqualTo(before + 1);
    }

    @DisplayName("매핑되어 있는 Result 객체를 올바르게 반환하는지 테스트")
    @ParameterizedTest
    @CsvSource({
            "0, false, NO_PROFIT",
            "1, false, NO_PROFIT",
            "2, false, NO_PROFIT",
            "3, false, THREE_RESULT",
            "4, false, FOUR_RESULT",
            "5, false, FIVE_RESULT",
            "5, true, FIVE_WITH_BONUS_RESULT",
            "6, false, SIX_RESULT",
    })
    void matchingSuccessTest(int matchingNumber, boolean bonus, Result expected) {
        // when
        Result result = matches(matchingNumber, bonus);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("잘못된 값을 입력하는 경우 ZERO를 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "-1, false",
            "7, true",
            "12, false"
    })
    void invalidInputTest(int matchingNumber, boolean bonus) {
        // when
        Result result = matches(matchingNumber, bonus);

        // then
        assertThat(result).isEqualTo(NO_PROFIT);
    }

}
