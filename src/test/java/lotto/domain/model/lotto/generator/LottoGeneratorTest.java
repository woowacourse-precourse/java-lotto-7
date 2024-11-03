package lotto.domain.model.lotto.generator;

import lotto.common.config.Factory;
import lotto.domain.model.user.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;


class LottoGeneratorTest {

    Factory factory = new Factory();
    LottoAutoGenerator lottoGenerator;

    @BeforeEach
    void setUp() {
        lottoGenerator = factory.lottoAutoGenerator();
    }

    @Nested
    @DisplayName("generateByQuantity 메서드는")
    class GenerateTest {

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        @DisplayName("입력 개수만큼 로또를 생성하여 반환해야 한다.")
        void issueByAmount(int quantity) {
            //given

            //when
            List<Lotto> lottos = lottoGenerator.generateByQuantity(quantity);

            //then
            Assertions.assertThat(lottos.size()).isEqualTo(quantity);
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 3})
        @DisplayName("중복된 번호가 없는 로또를 생성하여 반환해야 한다.")
        void issueByAmount2(int quantity) {
            //given

            //when
            List<Lotto> lottos = lottoGenerator.generateByQuantity(quantity);

            //then
            for (Lotto lotto : lottos) {
                Assertions.assertThat(new HashSet<>(lotto.getNumbers()).size())
                        .isEqualTo(6);
            }
        }

    }
}