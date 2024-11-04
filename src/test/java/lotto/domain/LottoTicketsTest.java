package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static lotto.utils.Constants.ENTER;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

    @Test
    @DisplayName("돈을 입력받고 개수 확인")
    void test1() {
        Money money = new Money("10000");

        LottoTickets lottoTickets = LottoTickets.generate(money);

        assertThat(lottoTickets.size()).isEqualTo(10);
    }

    @Test
    @DisplayName("ToString 테스트")
    void test2(){
        assertRandomUniqueNumbersInRangeTest(() ->{
            Money money = new Money("8000");
            LottoTickets lottoTickets = LottoTickets.generate(money);
            assertThat(lottoTickets.toString()).contains( "[8, 21, 23, 41, 42, 43]",
                    "[3, 5, 11, 16, 32, 38]",
                    "[7, 11, 16, 35, 36, 44]",
                    "[1, 8, 11, 31, 41, 42]",
                    "[13, 14, 16, 38, 42, 45]",
                    "[7, 11, 30, 40, 42, 43]",
                    "[2, 13, 22, 32, 38, 45]",
                    "[1, 3, 5, 14, 22, 45]", ENTER);

        }, List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45) );
    }

}
