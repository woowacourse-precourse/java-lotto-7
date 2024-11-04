package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import lotto.repository.InMemoryLottoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceImplTest {
    private LottoService lottoService;

    @BeforeEach
    void setService() {
        lottoService = new LottoServiceImpl(new InMemoryLottoRepository());
    }

    @DisplayName("구입 금액 부족")
    @Test
    void validatePurchaseAmountLack() {
        assertThrows(IllegalArgumentException.class, () ->
                lottoService.purchaseLotto("0"));
    }

    @DisplayName("구입 금액 숫자형식")
    @Test
    void validatePurchaseAmountNumeric() {
        assertThrows(IllegalArgumentException.class, () ->
                lottoService.purchaseLotto("1000j"));
    }

    @DisplayName("구입 금액 단위예외")
    @Test
    void validatePurchaseAmountDivide() {
        assertThrows(IllegalArgumentException.class, () ->
                lottoService.purchaseLotto("123"));
    }

    @DisplayName("6개가 아닌 당첨 번호")
    @Test
    void validateWinningNumbersCount() {
        assertThrows(IllegalArgumentException.class, () ->
                lottoService.generateLottoReport(
                        "8000",
                        "1,2,3,4,5",
                        "7"
                ));
        assertThrows(IllegalArgumentException.class, () ->
                lottoService.generateLottoReport(
                        "8000",
                        "1,2,3,4,5,6,7",
                        "8"
                ));
    }

    @DisplayName("숫자가 아닌 번호")
    @Test
    void validateNumberNumeric() {
        assertThrows(IllegalArgumentException.class, () ->
                lottoService.generateLottoReport(
                        "8000",
                        "1,2,3,4,5,6",
                        "7jy"
                ));
    }

    @DisplayName("범위를 벗어난 번호")
    @Test
    void validateNumberRange() {
        assertThrows(IllegalArgumentException.class, () ->
                lottoService.generateLottoReport(
                        "8000",
                        "1,2,3,4,5,6",
                        "0"
                ));
        assertThrows(IllegalArgumentException.class, () ->
                lottoService.generateLottoReport(
                        "8000",
                        "1,2,3,4,5,6",
                        "46"
                ));
    }
}