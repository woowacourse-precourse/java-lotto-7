package lotto.manager;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.Lotto;
import org.junit.jupiter.api.Test;
import java.util.List;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoManagerTest extends NsTest {
    private LottoManager lottoManager = new LottoManager();

    @Test
    void 구입_금액이_1000일_경우_1개_구매() {
        // given
        long payment = 1000;

        // when
        List<Lotto> lottos = lottoManager.create(payment);

        // then
        assertEquals(lottos.size(), 1);
    }

    @Test
    void 당첨_번호_입력시_당첨_로또_생성() {
        // given
        String writeNumber = "1,2,3,4,5,6";

        // when
        lottoManager.createWinningLotto(writeNumber);

        // then
        Lotto winningLotto = lottoManager.getWinningLotto();
        assertEquals(List.of(1, 2, 3, 4, 5, 6), winningLotto.getNumbers());
    }

    @Test
    void winningCalculator_정상작동_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("1000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "3개 일치 (5,000원) - 1개"
                    );
                },
                List.of(1, 2, 3, 41, 42, 43)
        );
    }

    @Test
    void earningsRateCalculator_정상작동_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    run("8000", "1,2,3,4,5,6", "7");
                    assertThat(output()).contains(
                            "총 수익률은 62.5%입니다."
                    );
                },
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}