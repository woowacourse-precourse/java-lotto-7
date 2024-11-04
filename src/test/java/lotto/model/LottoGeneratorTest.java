package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;


class LottoGeneratorTest {
    @Test
    void 로또는_중복되는_숫자_없이_6개가_생성된다() {
        Lotto lotto = LottoGenerator.generateLotto();

        List<LottoNumber> lottoNumbers = lotto.getNumbers();

        assertThat(lottoNumbers).hasSize(6);

    }

    @Test
    void 생성되는_로또는_1부터_45까지의_숫자로_만들어진다() {
        Lotto lotto = LottoGenerator.generateLotto();
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        assertThat(lottoNumbers).allMatch(number -> number.number() >= 1 && number.number() <= 45);
    }

    @Test
    void 생성되는_로또는_중복이_없다()
    {
        Lotto lotto = LottoGenerator.generateLotto();
        List<LottoNumber> lottoNumbers = lotto.getNumbers();
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }
}
