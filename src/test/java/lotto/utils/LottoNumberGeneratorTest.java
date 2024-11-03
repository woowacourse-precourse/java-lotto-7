package lotto.utils;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static lotto.constant.LottoGameRule.MAX_LOTTO_NUMBER;
import static lotto.constant.LottoGameRule.MIN_LOTTO_NUMBER;
import static lotto.constant.LottoGameRule.NUMBER_OF_PICKS;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.Application;
import org.junit.jupiter.api.Test;

public class LottoNumberGeneratorTest extends NsTest {
    @Test
    void 오름차순으로_정렬된_로또_번호를_생성한다() {
        List<Integer> expected = List.of(8, 21, 23, 41, 42, 43);

        assertRandomUniqueNumbersInRangeTest(() -> {
                    List<Integer> actual =
                            Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER.getValue(), MAX_LOTTO_NUMBER.getValue(),
                                    NUMBER_OF_PICKS.getValue());

                    assertThat(actual).isEqualTo(expected);
                    System.out.println(actual);
                }, expected
        );
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
