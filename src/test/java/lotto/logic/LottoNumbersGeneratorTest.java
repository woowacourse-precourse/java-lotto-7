package lotto.logic;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LottoNumbersGeneratorTest {

    @Test
    void 로또_자동_추첨_테스트() {
        //given
        int count = 5;

        //when
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator(count);

        //then
        assertThat(count)
                .isEqualTo(lottoNumbersGenerator.getLottos().size());
    }

    @Test
    void 로또_자동_추첨_많이_테스트() {
        //given
        int count = 100000;

        //when
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator(count);

        //then
        assertThat(count)
                .isEqualTo(lottoNumbersGenerator.getLottos().size());
    }

    @Test
    void 자동_추첨된_리스트_개수_테스트_assertions_라이브러리_사용() {
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator(5);
                    assertThat(lottoNumbersGenerator.getLottos().size()).isEqualTo(5); // 원하는 리스트 개수로 확인
                },
                List.of(1, 2, 3, 4, 5, 6), // 예상 리스트 1
                List.of(7, 8, 9, 10, 11, 12), // 예상 리스트 2
                List.of(13, 14, 15, 16, 17, 18), // 예상 리스트 3
                List.of(19, 20, 21, 22, 23, 24), // 예상 리스트 4
                List.of(25, 26, 27, 28, 29, 30) // 예상 리스트 5
        );
    }
}