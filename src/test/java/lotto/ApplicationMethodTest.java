package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationMethodTest extends NsTest {
    @Test
    public void testValidateInputLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            Application.validateInputLength("10000000000");
        });
    }

    @Test
    public void testValidatePrice() {
        assertEquals(1000, Application.validatePrice("1000"));
        assertEquals(2000000000, Application.validatePrice("2000000000"));

        assertThrows(IllegalArgumentException.class, () -> {
            Application.validatePrice("500");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Application.validatePrice("3000000000");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Application.validatePrice("1500a");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Application.validatePrice("1500");
        });
    }

    @Test
    public void testValidateBonus() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(7, Application.validateBonus(winningNumbers, "7"));

        assertThrows(IllegalArgumentException.class, () -> {
            Application.validateBonus(winningNumbers, "5");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Application.validateBonus(winningNumbers, "abc");
        });
    }

    @Test
    public void testPrintWin() {
        Lotto[] lottos = {
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8))
        };
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonus = 7;

        int total = Application.printWin(lottos, winningLotto, bonus);
        assertTrue(total > 0);
    }

    @Test
    public void testFormatPrize() {
        assertEquals("1,000", Application.formatPrize(1000));
        assertEquals("20,000", Application.formatPrize(20000));
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
