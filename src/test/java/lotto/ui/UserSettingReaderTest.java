package lotto.ui;

import lotto.basic.StringPrinterDummy;
import lotto.basic.StringReaderStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserSettingReaderTest {
    private StringReaderStub reader;
    private UserSettingReader userSettingReader;

    @BeforeEach
    void beforeEach() {
        reader = new StringReaderStub();
        userSettingReader = new UserSettingReader(reader, new StringPrinterDummy());
    }

    @DisplayName("사용자가 입력한 시드 머니를 읽어올 수 있다")
    @Test
    void test1() {
        reader.setTestValue("1000");
        assertEquals(userSettingReader.readBuyerSeedMoneyAmount(), 1000);
    }

    @DisplayName("사용자가 입력한 당첨 번호를 읽어올 수 있다.")
    @Test
    void test2() {
        reader.setTestValue("1,2,3,4");
        assertEquals(userSettingReader.readWinningNumbers(), List.of(1,2,3,4));
    }

    @DisplayName("사용자가 입력한 보너스 번호를 읽어올 수 있다.")
    @Test
    void test3() {
        reader.setTestValue("14");
        assertEquals(userSettingReader.readBonusNumber(), 14);
    }

}