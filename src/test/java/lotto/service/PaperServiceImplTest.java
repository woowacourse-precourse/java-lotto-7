package lotto.service;

import static lotto.exception.errorMessage.IllegalArgumentExceptionMessage.PURCHASE_AMOUNT_NOT_NATURE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.exception.errorMessage.IllegalArgumentExceptionMessage;
import lotto.repository.PaperRepository;
import lotto.repository.PaperRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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


}