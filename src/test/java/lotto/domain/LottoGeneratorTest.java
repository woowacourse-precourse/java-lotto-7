package lotto.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {
    LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    void 로또번호_생성_테스트() {
        assertRandomUniqueNumbersInRangeTest(
                ()->{
                    Lotto lotto = lottoGenerator.generate();
                    assertThat(lotto.toString()).isEqualTo("[1, 3, 5, 14, 22, 45]");
                },
                List.of(1, 3, 5, 14, 22, 45)
        );
    }

    @Test
    void 잘못된_번호가_생성되면_재시도() {
        assertRandomUniqueNumbersInRangeTest(
                ()->{
                    Lotto lotto = lottoGenerator.generate();
                    assertThat(lotto.toString()).isEqualTo("[1, 3, 5, 14, 22, 45]");
                },
                List.of(1, 3, 5, 14, 22, 22),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }
}
