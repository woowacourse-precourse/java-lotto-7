package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lottoController.GenerateLottoController;


public class GenerateLottoControlTest {
    private GenerateLottoController generateLottoController;

    @BeforeEach
    public void setUp(){
        generateLottoController = new GenerateLottoController();
    }

    @Test
    public void validateMoneyTest_유효값테스트(){
        String inputMoney = "13000";
        int money = generateLottoController.validateMoney(inputMoney);

        assertEquals(13000, money);
    }

    @Test
    public void validateMoneyTest_0보다_낮은값(){
        String inputMoney = "13000";
        int money = generateLottoController.validateMoney(inputMoney);

        assertEquals(13000, money);
    }

    @Test
    public void validateMoneyTest_1000단위_아닌_숫자(){
        String inputMoney = "13100";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->{
            generateLottoController.validateMoney(inputMoney);
        });

        assertThat(e.getMessage()).contains("1000원 단위로 입력 가능합니다");
    }

    @Test
    public void validateMoneyTest_숫자가_아닌_값(){
        String inputMoney = "가나다";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->{
            generateLottoController.validateMoney(inputMoney);
        });

        assertThat(e.getMessage()).contains("숫자만 입력 가능합니다");
    }

    @Test
    public void validateMoneyTest_0보다_작은_값(){
        String inputMoney = "-3";

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, ()->{
            generateLottoController.validateMoney(inputMoney);
        });

        assertThat(e.getMessage()).contains("1000원보다 더 커야 합니다");
    }

}
