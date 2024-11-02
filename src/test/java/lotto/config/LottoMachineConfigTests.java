package lotto.config;

import static org.junit.jupiter.api.Assertions.*;

import lotto.controller.LottoMachineController;
import lotto.model.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineConfigTests {

    @Test
    @DisplayName("LottoMachine 객체가 싱글톤 객체인지 확인")
    void getLottoMachineTest() {
        LottoMachine expected = LottoMachineConfig.lottoMachine;

        assertEquals(
                LottoMachineConfig.getLottoMachine().hashCode(),
                expected.hashCode()
        );
    }

    @Test
    @DisplayName("LottoMachineController 객체가 싱글톤 객체인지 확인")
    void getLottoMachineControllerTest() {
        LottoMachineController expected = LottoMachineConfig.lottoMachineController;

        assertEquals(
                LottoMachineConfig.getLottoMachineController().hashCode(),
                expected.hashCode()
        );
    }
}