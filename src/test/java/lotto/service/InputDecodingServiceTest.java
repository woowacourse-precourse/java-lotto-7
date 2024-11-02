package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.constant.LottoConfiguration;
import lotto.model.PurchasePrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputDecodingServiceTest {

    private InputParsingService inputParsingService;

    @BeforeEach
    void beforeEach() {
        inputParsingService = new InputParsingService();
    }

    @DisplayName("검증 완료된 구매 금액에 대한 입력값 디코딩")
    @Test
    void 검증_완료된_구매_금액에_대한_입력값_디코딩() {
        int givenPrice = LottoConfiguration.LOTTO_PRICE * 15;
        String rawPurchasePrice = String.valueOf(givenPrice);

        PurchasePrice actualPrice = inputParsingService.parsePurchasePrice(rawPurchasePrice);

        assertThat(actualPrice)
                .usingRecursiveComparison()
                .isEqualTo(new PurchasePrice(givenPrice));
    }
}