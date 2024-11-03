package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottosTest {

    @ParameterizedTest
    @CsvSource({"4", "5", "6"})
    @DisplayName("랜덤 숫자들을 가지는 로또를 원하는 갯수만큼 생성할 수 있다.")
    void 원하는_갯수만큼_로또_생성_테스트(int size) {
        // given, when
        Lottos lottos = Lottos.randomFrom(size);

        // then
        Assertions.assertThat(lottos.isSize(size)).isTrue();
    }
}
