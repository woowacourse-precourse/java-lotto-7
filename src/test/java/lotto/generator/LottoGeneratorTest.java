package lotto.generator;

import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.generator.LottoGenerator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoGeneratorTest {

    private LottoGenerator lottoGenerator;
    private List<Lotto> lottos;

    @BeforeEach
    void setUp() {
        lottoGenerator = new LottoGenerator();
        lottos = lottoGenerator.generateLotto(10);
    }

    @Test
    void 로또_번호_6개_생성() {
        lottos.forEach(lotto ->
                assertEquals(COUNT, lotto.getNumbers().size())
        );
    }

    @Test
    void 로또_번호_범위_검증() {
        lottos.forEach(lotto ->
                assertThat(lotto.getNumbers()).allMatch(number -> number >= START_INCLUSIVE && number <= END_INCLUSIVE)
        );
    }

    @Test
    void 로또_번호_오름차순_검증() {
        lottos.forEach(lotto ->
                assertThat(lotto.getNumbers()).isSorted()
        );
    }

    @Test
    void 로또_번호_중복_검증() {
        lottos.forEach(lotto ->
                assertThat(lotto.getNumbers()).doesNotHaveDuplicates()
        );
    }
}