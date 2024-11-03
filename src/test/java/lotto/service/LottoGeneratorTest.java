package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoGeneratorTest {
    LottoGenerator lottoGenerator = new LottoGenerator();

    @Test
    public void 로또_한개_발행_테스트() {
        //given
        Lotto lotto = lottoGenerator.generateOne();
        //when
        //then
        Assertions.assertThat(lotto).isNotNull();
    }

    @ParameterizedTest
    @CsvSource({"1000,1",
            "4000,4",
            "98000,98"})
    public void 로또_여러개_발행_테스트(int money, int expectedAmount) {
        //given
        List<Lotto> lottos = lottoGenerator.generateMany(money);
        //when
        //then
        Assertions.assertThat(lottos.size()).isEqualTo(expectedAmount);
    }

    @ParameterizedTest
    @ValueSource(ints = {1001, 800, 1, 234234234})
    public void 로또_여러개_발행_테스트(int money) {
        Assertions.assertThatThrownBy(() -> lottoGenerator.generateMany(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1000단위로 입력해주세요.");
    }
}
