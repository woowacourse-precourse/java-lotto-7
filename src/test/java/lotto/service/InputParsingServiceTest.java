package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.constant.LottoConfiguration;
import lotto.generator.RawInputGenerator;
import lotto.model.Lotto;
import lotto.model.PurchasePrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParsingServiceTest {

    private InputParsingService inputParsingService;

    @BeforeEach
    void beforeEach() {
        inputParsingService = new InputParsingService();
    }

    @DisplayName("구매 금액에 대한 입력값 파싱")
    @Test
    void 구매_금액에_대한_입력값_파싱() {
        int givenPrice = LottoConfiguration.LOTTO_PRICE * 15;
        String rawPurchasePrice = String.valueOf(givenPrice);

        PurchasePrice actualPrice = inputParsingService.parsePurchasePrice(rawPurchasePrice);

        assertThat(actualPrice)
                .usingRecursiveComparison()
                .isEqualTo(new PurchasePrice(givenPrice));
    }

    @DisplayName("당첨 번호에 대한 입력값 파싱")
    @Test
    void 당첨_번호에_대한_입력값_파싱() {
        List<Integer> givenNumbers = List.of(1, 2, 3, 4, 5, 6);
        String rawWinningNumbers = RawInputGenerator.makeRawWinningNumbers(givenNumbers);

        Lotto actualWinningLotto = inputParsingService.parseWinningLotto(rawWinningNumbers);

        Lotto expectedWinningLotto = new Lotto(givenNumbers);
        assertThat(actualWinningLotto)
                .usingRecursiveComparison()
                .isEqualTo(expectedWinningLotto);
    }
}