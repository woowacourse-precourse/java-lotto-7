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
        if (prize.getExplain().equals("1등")) {
            return "1등: 6개 번호 일치 / 2,000,000,000원";
        }
        if (prize.getExplain().equals("2등")) {
            return "2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원";
        }
        if (prize.getExplain().equals("3등")) {
            return "3등: 5개 번호 일치 / 1,500,000원";
        }
        if (prize.getExplain().equals("4등")) {
            return "4등: 4개 번호 일치 / 50,000원";
        }
        if (prize.getExplain().equals("5등")) {
            return "5등: 3개 번호 일치 / 5,000원";
        }
        return "";
    }
}
