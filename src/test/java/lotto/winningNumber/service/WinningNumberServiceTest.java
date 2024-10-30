package lotto.winningNumber.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.winningNumber.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberServiceTest {
    private final WinningNumberService winningNumberService = new WinningNumberService();

    @Test
    @DisplayName("[,]로 구분하는 문자열과 보너스번호를 받아 당첨번호를 생성한다")
    void createWinningNumber() throws Exception {
        // given
        String numbers = "1,2,3,4,5,6";
        String bonus = "7";

        // when
        WinningNumber winningNumber = winningNumberService.create(numbers, bonus);

        // then
        assertThat(winningNumber).isNotNull()
                .extracting("numbers", "bonus")
                .containsExactlyInAnyOrder(List.of(1, 2, 3, 4, 5, 6), 7);
    }

}