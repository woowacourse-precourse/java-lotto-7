package lotto.model;

import lotto.domain.Bonus;
import lotto.domain.WinningLotto;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoCollectionTest {
    @Test
    @DisplayName("로또 컬랙션 내부 값 확인 테스트")
    public void lottoCollectionTest() {
        assertRandomUniqueNumbersInRangeTest(
            () -> {
                LottoCollection lottoCollection = new LottoCollection(1);
                String state = lottoCollection.getState();
                String result = "[1, 2, 3, 4, 5, 6]"+ "\n";
                assertEquals(result, state);
            },
                List.of(1,2,3,4,5,6)
        );
    }

    @Test
    @DisplayName("로또 컬랙션 등수 및 상금 확인 테스트")
    public void compareWinningLottoTest() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    //given
                    LottoCollection lottoCollection = new LottoCollection(1);
                    String number = "1,2,3,4,5,6";
                    WinningNumber winningNumber = new WinningNumber(number);
                    Bonus bonus = new Bonus("7");
                    WinningLotto winningLotto = new WinningLotto(winningNumber, bonus);
                    lottoCollection.compareWinningLotto(winningLotto);

                    //when
                    int totalWinnings = lottoCollection.getTotalWinnings();
                    int[] winningResult = lottoCollection.getWinningResult();
                    //then
                    assertThat(totalWinnings).isEqualTo(2000000000);
                    assertThat(winningResult[0]).isEqualTo(1);
                },
                List.of(1,2,3,4,5,6)
        );
    }
}