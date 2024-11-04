package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class InputTest extends Input{

    private  Input instance;
    private String testInput;
    @Override
    public String getUserInput() {
        return testInput;
    }

    @BeforeEach
    void init() {
        instance=this;
    }

    @Test
    void PurchaseAmountTest() {

        testInput="1000";
        instance.setPurchaseAmount();
        assertEquals(1000,instance.getPurchaseAmount());

    }


    @Test
    void ValidPurchaseAmountTest1() {

        testInput="1050";
        assertThrows(IllegalArgumentException.class,() ->{instance.setPurchaseAmount();}
                ,"[ERROR] 입력 금액이 1000원 단위여야 합니다.");

    }


    @Test
    void ValidPurchaseAmountTest2() {

        testInput="qwer123";
        assertThrows(NumberFormatException.class,() ->{instance.setPurchaseAmount();}
                ,"[ERROR] 당첨번호 입력은 숫자만 입력할수있습니다.");

    }

    @Test
    void ValidPurchaseAmountTest3() {

        testInput="0";
        assertThrows(IllegalArgumentException.class,() ->{instance.setPurchaseAmount();}
                ,"[ERROR] 입력 금액이 최소한 1000원 이상이여야 합니다.");

    }

    @Test
    void invalidLottoWinningNumbersSizeTest1() {

        Set<Integer> validInput = Set.of(1, 2, 3, 4, 5, 6);
        assertDoesNotThrow(() -> instance.validateLottoWinningNumbersSize(validInput),
                "유효한 경우 예외가 발생하지 않아야 합니다.");

    }

    @Test
    void invalidLottoWinningNumbersSizeTest2() {

        Set<Integer> invalidInput = Set.of(1, 2, 3, 4, 5);
        assertThrows(IllegalArgumentException.class,
                () -> instance.validateLottoWinningNumbersSize(invalidInput),
                "[ERROR] 당첨 번호가 6개가 아니거나 중복되는 숫자가 존재합니다.");


        Set<Integer> invalidInput2 = Set.of(1, 2, 3, 4, 5, 6, 7);
        assertThrows(IllegalArgumentException.class,
                () -> instance.validateLottoWinningNumbersSize(invalidInput2),
                "[ERROR] 당첨 번호가 6개가 아니거나 중복되는 숫자가 존재합니다.");


    }

    @Test
    void invalidLottoWinningNumbersScopeTest() {

        int validInput = 22;
        assertDoesNotThrow(() -> instance.validateLottoWinningNumbersScope(validInput),
                "유효한 경우 예외가 발생하지 않아야 합니다.");

    }

    @Test
    void invalidLottoWinningNumbersScopeTest2() {

        int invalidInput = -1;
        assertThrows(IllegalArgumentException.class,
                () -> instance.validateLottoWinningNumbersScope(invalidInput),
                "[ERROR] 당첨 번호는 1~45 사이 숫자여야 합니다.");


        int invalidInput2 = 46;
        assertThrows(IllegalArgumentException.class,
                () -> instance.validateLottoWinningNumbersScope(invalidInput2),
                "[ERROR] 당첨 번호는 1~45 사이 숫자여야 합니다.");
    }



    @Test
    void convertLottoWinningNumbersTest1() {

        String input="1,2,3,4,5,6";
        Set<Integer> expectedOutput = Set.of(1,2,3,4,5,6);

        Set<Integer> result=instance.convertLottoWinningNumbers(input);
        assertEquals(expectedOutput,result);

    }

    @Test
    void convertLottoWinningNumbersTest2() {

        String input="1,2,3,4,5";

        assertThrows(IllegalArgumentException.class,
                () -> instance.convertLottoWinningNumbers(input),
                "[ERROR] 당첨 번호는 6개여야 합니다.");

    }

    @Test
    void convertLottoWinningNumbersTest3() {

        String input="1,2,3,4,50";

        assertThrows(IllegalArgumentException.class,
                () -> instance.convertLottoWinningNumbers(input),
                "[ERROR] 당첨 번호는 지정된 범위 내에 있어야 합니다.");

    }

    @Test
    void convertLottoWinningNumbersTest4() {

        String input = "1,2,3,4,5,abc";

        assertThrows(NumberFormatException.class,
                () -> instance.convertLottoWinningNumbers(input),
                "[ERROR] 당첨번호 입력은 숫자만 입력할 수 있습니다.");
    }

    @Test
    void invalidBonusNumbersScopeTest() {

        int invalidInput = -1;
        assertThrows(IllegalArgumentException.class,
                () -> instance.validateBonusNumberScope(invalidInput),
                "[ERROR] 당첨 번호는 1~45 사이 숫자여야 합니다.");


        int invalidInput2 = 46;
        assertThrows(IllegalArgumentException.class,
                () -> instance.validateBonusNumberScope(invalidInput2),
                "[ERROR] 당첨 번호는 1~45 사이 숫자여야 합니다.");
    }

    @Test
    void invalidBonusNumbersDuplicationTest() {

        testInput="1,2,3,4,5,6";
        instance.setLottoWinningNumbers();
        int invalidInput=5;
        assertThrows(IllegalArgumentException.class,
                () -> instance.validateBonusNumDuplication(invalidInput),
                "[ERROR] 당첨 번호는 1~45 사이 숫자여야 합니다.");
    }

    @Test
    void LottoWinningNumTest() {

        testInput="6,5,4,3,2,1";
        List<Integer> validOutput=List.of(1,2,3,4,5,6);
        instance.setLottoWinningNumbers();
        assertEquals(validOutput,instance.getLottoWinningNumbers());

    }

    @Test
    void BonusNumberTest1() {

        testInput="1,2,3,4,5,6";
        instance.setLottoWinningNumbers();
        testInput="9";
        instance.setBonusNumber();
        assertEquals(9,instance.getBonusNumber());

    }

    @Test
    void BonusNumberTest2() {

        testInput="1,2,3,4,5,6";
        instance.setLottoWinningNumbers();
        testInput="5";
        assertThrows(IllegalArgumentException.class,() ->{instance.setBonusNumber();}
                ,"[ERROR] 보너스 번호가 당첨 번호와 중복됩니다.");

    }

    @Test
    void BonusNumberTest3() {

        testInput="qwer123";
        assertThrows(NumberFormatException.class,() ->{instance.setBonusNumber();}
                ,"[ERROR] 당첨번호 입력은 숫자만 입력할수있습니다.");

    }





}
