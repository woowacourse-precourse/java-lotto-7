package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {

    private final LottoGenerator lottoGenerator = new LottoGenerator();

    @ParameterizedTest
    @ValueSource(strings = {"4000", "8000", "12000"})
    void 로또_생성_테스트(String amount){
        lottoGenerator.generate(amount);
        Lotto[] lotto = lottoGenerator.getLotto();

        assertThat(lotto.length).isEqualTo(Integer.parseInt(amount)/1000);
        for (Lotto singleLotto : lotto) {
            assertThat(singleLotto.getNumbers()).hasSize(6);
            assertThat(singleLotto.getNumbers()).hasOnlyElementsOfTypes(Integer.class);
        }
        System.out.println();
    }

    @ParameterizedTest
    @ValueSource(strings = {"4500", "0", "-3700", "120"})
    void 로또_생성_테스트_실패(String amount){
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(
                        () -> lottoGenerator.generate(amount)
                );
    }
}