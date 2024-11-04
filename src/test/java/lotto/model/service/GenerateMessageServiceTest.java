package lotto.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.model.domain.Lotto;
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
        assertThat(generateMessageService.generatePurchasesMessage(lottos).getPurchasesMessage()).isEqualTo(expected);
    }

    static Stream<Arguments> generatePurchasesCase() {
        return Stream.of(
                Arguments.of(
                        List.of(new Lotto(List.of(10, 2, 3, 4, 5, 6)),
                                new Lotto(List.of(10, 2, 13, 4, 5, 6))),
                        List.of(2, 3, 4, 5, 6, 10).toString() + "%n"
                                + List.of(2, 4, 5, 6, 10, 13).toString() + "%n")
        );
    }
}