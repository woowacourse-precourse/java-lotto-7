package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    void 랜덤번호로_로또를_발행할_수_있다() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto generate = lottoGenerator.generate();
        assertThat(generate).isInstanceOf(Lotto.class);
    }

    @Test
    void 구입금액만큼_로또를_발행할_수_있다() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lottos generate = lottoGenerator.generate(new Money(3000L));
        assertThat(generate.size()).isEqualTo(3);
    }

    @Test
    void 당첨번호를_입력하면_해당_번호로_로또를_발행할_수_있다() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto generate = lottoGenerator.generate("1,2,3,4,5,6");
        Lotto expected = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThat(generate).isEqualTo(expected);
    }

}