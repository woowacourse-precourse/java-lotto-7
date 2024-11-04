package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.WinningNumber;
import lotto.service.WinningNumberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

public class WinningNumberServiceTest {
    List<Lotto> lottos;
    String winningNumber;
    int bonusNumber;
    WinningNumberService winningNumberService;

    @BeforeEach
    void init() {
        lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1,2,3,4,5,6)));
        lottos.add(new Lotto(List.of(7,8,9,10,11,12)));

        winningNumber = "1,2,3,8,9,13";
        bonusNumber = 7;
        winningNumberService = new WinningNumberService(lottos, winningNumber, bonusNumber);

    }

    @Test
    void 당첨_번호_생성_테스트() {
        WinningNumber winning = winningNumberService.createWinningNumber(winningNumber, bonusNumber);

        assertThat(winning.getNumbers().size()).isEqualTo(6);
        assertThat(winning.getNumbers()).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 보너스_번호_생성_테스트() {
        WinningNumber winning = winningNumberService.createWinningNumber(winningNumber, bonusNumber);

        assertThat(winning.getBonusNumber()).isEqualTo(7);
    }
}
