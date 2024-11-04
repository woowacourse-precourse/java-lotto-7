package lotto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class InputReaderTest {

    InputReader inputReader = new InputReader();
    InputStream inputStream = System.in;

    @BeforeEach
    void setup(){
        String testString = "14000\ns\n-1\n14001";
        System.setIn(new ByteArrayInputStream(testString.getBytes()));
    }

    @AfterEach
    void rollBack(){
        System.setIn(inputStream);
    }
    @Test
    void readLottoPrice() {
        //14000원 입력
        Assertions.assertDoesNotThrow(()->{
            int p = inputReader.readLottoPrice();
        });

        //s 입력
        IllegalArgumentException error1 = assertThrows(IllegalArgumentException.class, () -> {
            int p = inputReader.readLottoPrice();
        });
        assertEquals(error1.getMessage(), "구입 금액을 숫자로 입력해 주세요.");
        //음수 -1 입력
        IllegalArgumentException error2 = assertThrows(IllegalArgumentException.class, () -> {
            int p = inputReader.readLottoPrice();
        });
        assertEquals(error2.getMessage(), "구입 금액을 양수로 입력해 주세요.");
        //나누어 떨어지지 않는 14001 입력
        IllegalArgumentException error3 = assertThrows(IllegalArgumentException.class, () -> {
            int p = inputReader.readLottoPrice();
        });
        assertEquals(error3.getMessage(), "구입 금액은 1000로 나누어 떨어져야 합니다.");
    }
}