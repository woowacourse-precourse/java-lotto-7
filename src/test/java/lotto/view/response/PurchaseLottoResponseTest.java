package lotto.view.response;

import lotto.mock.number_generator.RealRandomNumberGenerator;
import lotto.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("PurchaseLottoResponse 테스트")
public class PurchaseLottoResponseTest {

    private static final RealRandomNumberGenerator realRandomNumberGenerator = new RealRandomNumberGenerator();

    static Stream<Arguments> 로또_일급_컬렉션_객체로부터_생성된다_테스트_케이스() {
        return Stream.of(
                makeArguments(Lottos.generateBy(realRandomNumberGenerator, 3)),
                makeArguments(Lottos.generateBy(realRandomNumberGenerator, 6)),
                makeArguments(Lottos.generateBy(realRandomNumberGenerator, 10))
        );
    }

    static Arguments makeArguments(Lottos lottos) {
        return Arguments.of(
                lottos,
                lottos.getAllLottoNumbers().stream().map(LottoNumberResponse::from).toList(),
                lottos.getAllLottoNumbers().size()
        );
    }

    @ParameterizedTest(name = "lottos: {0}, expectedLottoNumberResponses: {1}, expectedPurchasedAmount: {2}")
    @MethodSource("로또_일급_컬렉션_객체로부터_생성된다_테스트_케이스")
    void 로또_일급_컬렉션_객체로부터_생성된다(
            Lottos lottos,
            List<LottoNumberResponse> expectedLottoNumberResponses,
            int expectedPurchasedAmount) {

        // when
        PurchaseLottoResponse purchaseLottoResponse = PurchaseLottoResponse.from(lottos);
        List<LottoNumberResponse> actualLottoNumberResponses = purchaseLottoResponse.getLottoNumberResponses();
        int actualPurchasedAmount = purchaseLottoResponse.getPurchasedAmount();

        // then
        for (int i = 0; i < actualLottoNumberResponses.size(); i++) {
            List<Integer> actualLottoNumbers = getLottoNumbers(actualLottoNumberResponses, i);
            List<Integer> expectedLottoNumbers = getLottoNumbers(expectedLottoNumberResponses, i);

            assertThat(actualLottoNumbers).containsExactlyElementsOf(expectedLottoNumbers);
        }
        assertThat(actualPurchasedAmount).isEqualTo(expectedPurchasedAmount);
    }

    private List<Integer> getLottoNumbers(List<LottoNumberResponse> lottoNumberResponses, int index) {
        return lottoNumberResponses.get(index).getLottoNumbers();
    }
}
