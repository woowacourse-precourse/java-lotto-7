package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.PurchasePrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

class InputParsingServiceTest {

    private InputParsingService inputParsingService;

    @BeforeEach
    void beforeEach() {
        inputParsingService = new InputParsingService();
    }

    @DisplayName("구매 금액에 대한 입력값 파싱")
    @ParameterizedTest(name = "\"{0}\"일 경우 : {1}")
    @CsvSource({"15000,15000", "150  00,15000"})
    void 구매_금액에_대한_입력값_파싱(String rawPurchasePrice, int expectedPurchasePrice) {
        PurchasePrice actualPrice = inputParsingService.parsePurchasePrice(rawPurchasePrice);

        assertThat(actualPrice)
                .usingRecursiveComparison()
                .isEqualTo(new PurchasePrice(expectedPurchasePrice));
    }

    @DisplayName("당첨 번호에 대한 입력값 파싱")
    @ParameterizedTest(name = "\"{0}\"일 경우 : {1}")
    @MethodSource()
    void 당첨_번호에_대한_입력값_파싱(String rawWinningNumbers, List<Integer> expectedWinningNumbers) {
        Lotto actualWinningLotto = inputParsingService.parseWinningLotto(rawWinningNumbers);

        Lotto expectedWinningLotto = new Lotto(expectedWinningNumbers);
        assertThat(actualWinningLotto)
                .usingRecursiveComparison()
                .isEqualTo(expectedWinningLotto);
    }

    static Stream<Arguments> 당첨_번호에_대한_입력값_파싱() {
        List<Integer> expectedWinningNumbers = List.of(1, 2, 3, 4, 5, 6);
        return Stream.of(
                Arguments.of("1,2,3,4,5,6", expectedWinningNumbers),
                Arguments.of("1,2,   3,4,5,6", expectedWinningNumbers),
                Arguments.of("   1,2,3,4,5,6", expectedWinningNumbers),
                Arguments.of("1,2,3,4,5,6  ", expectedWinningNumbers)
        );
    }

    @DisplayName("보너스 번호에 대한 입력값 파싱")
    @ParameterizedTest(name = "\"{0}\"일 경우 : {1}")
    @MethodSource()
    void 보너스_번호에_대한_입력값_파싱(String rawNumber, List<Integer> bannedNumbers, int expectedBonusNumber) {
        BonusNumber actualBonusNumber = inputParsingService.parseBonusNumber(rawNumber, bannedNumbers);

        assertThat(actualBonusNumber.getNumber()).isEqualTo(expectedBonusNumber);
    }

    static Stream<Arguments> 보너스_번호에_대한_입력값_파싱() {
        List<Integer> bannedNumbers = List.of(1, 2, 3, 4, 5, 6);
        return Stream.of(
                Arguments.of("15", bannedNumbers, 15),
                Arguments.of("    15", bannedNumbers, 15),
                Arguments.of("1 5", bannedNumbers, 15),
                Arguments.of("15   ", bannedNumbers, 15)
        );
    }
}