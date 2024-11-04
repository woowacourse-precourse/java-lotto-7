package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.dto.LottoResultDto;
import lotto.generator.LottoGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoServiceTest {
    private final LottoGenerator lottoGenerator = () -> List.of(1, 5, 10, 21, 34, 43);
    private final LottoService lottoService = new LottoService(lottoGenerator);

    @ParameterizedTest
    @MethodSource("testData")
    void 구매_금액에_따른_로또_갯수_생성(String purchasedAmount, int lottoCountResult) {
        LottoCount lottoCount = lottoService.getLottoCountByAmount(purchasedAmount);
        assertThat(lottoCount.getCount()).isEqualTo(lottoCountResult);
    }

    @Test
    void 구입된_금액만큼_랜덤으로_로또_생성() {
        LottoCount lottoCount = new LottoCount(1000);
        List<Lotto> lottos = lottoService.getLottosByCount(lottoCount);
        assertThat(lottos.getFirst().getNumbers()).isEqualTo(List.of(1, 5, 10, 21, 34, 43));
    }

    @Test
    void 당첨_로또_생성() {
        Lotto winningLotto = lottoService.getWinningLotto("1, 5, 10, 20, 36, 41");
        assertThat(winningLotto.getNumbers()).isEqualTo(List.of(1, 5, 10, 20, 36, 41));
    }

    @Test
    void 로또_결과() {
        Lotto firstLotto = Lotto.createFixedNumberLotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto secondLotto = Lotto.createFixedNumberLotto(List.of(1, 5, 10, 21, 34, 43));
        List<Lotto> lottos = List.of(firstLotto, secondLotto);
        Lotto winningLotto = Lotto.createFixedNumberLotto(List.of(1, 2, 5, 10, 20, 36));

        LottoResultDto lottoResult = lottoService.getResult(lottos, winningLotto, 3);
        assertThat(lottoResult.rateOfReturn()).isEqualTo(2750);
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.arguments("1000", 1),
                Arguments.arguments("2000", 2),
                Arguments.arguments("9000", 9),
                Arguments.arguments("12000", 12)
        );
    }
}
