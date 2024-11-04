package lotto.service;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.domain.dto.LottoResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoDrawServiceTest {

    private WinningLotto winningLotto;
    private LottoDrawService lottoDrawService;
    @BeforeEach
    void init(){
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        winningLotto = new WinningLotto(winningNumbers,7);
        lottoDrawService = new LottoDrawService();
    }

    @DisplayName("로또 하나의 당첨 결과를 도출합니다. 당첨 결과는 LottoResult객체로 반환됩니다")
    @ParameterizedTest
    @MethodSource("provideInputAndExpected")
    void 로또_개별_당첨_결과(Lotto lotto, LottoResult expected){
        LottoResult lottoResult = lottoDrawService.drawLotto(lotto, winningLotto);
        assertThat(lottoResult.getMatchingNumberCount())
                .isEqualTo(expected.getMatchingNumberCount());
        assertThat(lottoResult.isBonusMatch())
                .isEqualTo(expected.isBonusMatch());
    }

    static Stream<Arguments> provideInputAndExpected(){
        return Stream.of(
                Arguments.of(new Lotto(Arrays.asList(1,2,3,4,5,6)), new LottoResult(6,false)),
                Arguments.of(new Lotto(Arrays.asList(11,12,13,14,15,16)), new LottoResult(0,false)),
                Arguments.of(new Lotto(Arrays.asList(11,12,13,14,15,7)), new LottoResult(0,true)),
                Arguments.of(new Lotto(Arrays.asList(1,2,3,14,15,7)), new LottoResult(3,true))
        );
    }
}