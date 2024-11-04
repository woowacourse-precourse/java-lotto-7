package lotto.service;

import static lotto.exception.errorMessage.IllegalArgumentExceptionMessage.PURCHASE_AMOUNT_NOT_NATURE;
import static lotto.exception.errorMessage.IllegalArgumentExceptionMessage.PURCHASE_AMOUNT_UNIT;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.repository.paper.PaperRepository;
import lotto.repository.paper.PaperRepositoryImpl;
import lotto.service.paper.PaperServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
class PaperServiceImplTest {

    PaperServiceImpl paperService;
    PaperRepository paperRepository;

    @BeforeEach
    void init() {
        paperRepository = new PaperRepositoryImpl();
        paperService = new PaperServiceImpl(paperRepository);
    }
    @DisplayName("0 이하 입력 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -1000})
    void saveNotNatureExceptionPaper(int value) {
        assertThatThrownBy(() -> paperService.savePaper(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_NOT_NATURE.getMessage());
    }

    @DisplayName("1000단위가 아닌 값 입력 예외 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1001, 3200, 1, 123, 11200})
    void saveUnitExceptionPaper(int value) {
        assertThatThrownBy(() -> paperService.savePaper(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_UNIT.getMessage());
    }

    @DisplayName("1000단위가 아닌 값 입력 예외 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "3000:3", "11000:11"}, delimiter = ':')
    void savePaper(String amount, String count) {
        int purchaseAmount = Integer.parseInt(amount);
        int purchaseCount = Integer.parseInt(count);

        paperService.savePaper(purchaseAmount);

        assertEquals(paperRepository.getAllPaper().size(), purchaseCount);
    }
}