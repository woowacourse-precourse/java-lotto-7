package lotto.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.dto.LottoPurchasesDto;
import lotto.dto.LottoResultDto;
import lotto.dto.LottoResultMessageDto;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GenerateMessageServiceTest {

    private final GenerateMessageService generateMessageService = new GenerateMessageService();

    @DisplayName("구매 내역 메세지 생성 테스트입니다.")
    @ParameterizedTest
    @MethodSource("generatePurchasesCase")
    void generatePurchasesMessageTest(List<Lotto> lottos, String expected) {
        LottoPurchasesDto lottoPurchasesDto = generateMessageService.generatePurchasesMessage(lottos);
        assertThat(lottoPurchasesDto.getPurchasesMessage()).isEqualTo(expected);
    }

    static Stream<Arguments> generatePurchasesCase() {
        List<Lotto> lottos = List.of(new Lotto(List.of(10, 2, 3, 4, 5, 6)),
                new Lotto(List.of(10, 2, 13, 4, 5, 6)));
        String expected = List.of(2, 3, 4, 5, 6, 10) + "%n"
                + List.of(2, 4, 5, 6, 10, 13) + "%n";
        return Stream.of(
                Arguments.of(lottos, expected)
        );
    }

    @DisplayName("당첨 결과 메세지 생성 테스트입니다.")
    @ParameterizedTest
    @MethodSource("generateResultCase")
    void generatePurchasesMessageTest(LottoResultDto lottoResultDto, String expected) {
        LottoResultMessageDto lottoResultMessageDto = generateMessageService.generateResultMessage(lottoResultDto);
        assertThat(lottoResultMessageDto.getResultMessage()).isEqualTo(expected);
    }

    static Stream<Arguments> generateResultCase() {
        Map<LottoPrize, Integer> lottoResult = Map.of(
                LottoPrize.FIRST, 1, LottoPrize.SECOND, 1,
                LottoPrize.THIRD, 0, LottoPrize.FOURTH, 0, LottoPrize.FIFTH, 1
        );
        Double winningRate = (2030005000.0 / (4 * 1000)) * 100;
        String expectedWinningRate = String.format("%.1f", winningRate);
        String expectedMessage = "3개 일치 (5,000원) - 1개%n4개 일치 (50,000원) - 0개%n5개 일치 (1,500,000원) - 0개%n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - 1개%n6개 일치 (2,000,000,000원) - 1개%n";
        return Stream.of(
                Arguments.of(new LottoResultDto(lottoResult, expectedWinningRate), expectedMessage)
        );
    }
}