package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("로또 추첨 결과를 테스트한다.")
class LottoResultTest {

    @DisplayName("로또의 결과가 우승자인지 확인한다.")
    @ParameterizedTest
    @CsvSource(
            value = {"3,false", "4,false", "5,false", "5,true", "6,false"},
            delimiter = ','
    )
    void lottoResultTest1(int countMatchNumbers, boolean matchBonus) {
        LottoResult result = new LottoResult(countMatchNumbers, matchBonus);

        assertThat(result.isWinner()).isTrue();
    }

    @DisplayName("로또의 결과가 우승자가 아닌지 확인한다.")
    @ParameterizedTest
    @CsvSource(
            value = {"3,true", "4,true", "6,true"},
            delimiter = ','
    )
    void lottoResultTest2(int countMatchNumbers, boolean matchBonus) {
        LottoResult result = new LottoResult(countMatchNumbers, matchBonus);

        assertThat(result.isWinner()).isFalse();
    }
}