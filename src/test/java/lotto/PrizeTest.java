package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {
    @ParameterizedTest
    @EnumSource(Prize.class)
    @DisplayName("당첨_기준과_금액_출력_테스트")
    void 당첨_기준과_금액_출력_테스트(Prize prize) {
        assertThat(prize.toString()).isEqualTo(expected(prize));
    }

    private String expected(Prize prize) {
        //why can't I use switch/case?
        //how to handle "no return statement" without "else"
        if (prize == Prize.FIRST) {
            return "1등: 6개 번호 일치 / 2,000,000,000원";
        }
        if (prize == Prize.SECOND) {
            return "2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원";
        }
        if (prize == Prize.THIRD) {
            return "3등: 5개 번호 일치 / 1,500,000원";
        }
        if (prize == Prize.FOURTH) {
            return "4등: 4개 번호 일치 / 50,000원";
        }
        if (prize == Prize.FIFTH) {
            return "5등: 3개 번호 일치 / 5,000원";
        }
        return "";
    }
}
