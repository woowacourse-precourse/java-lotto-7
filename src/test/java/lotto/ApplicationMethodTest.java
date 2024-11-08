package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
    public void testMatchedCheck() {
        List<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> win_array = new ArrayList<>(Arrays.asList(1, 9, 10, 4, 5, 13));
        Lotto lotto = new Lotto(win_array);
        assertEquals(1, Application.matchedCheck(array, lotto, 0));
        assertEquals(0, Application.matchedCheck(array, lotto, 1));
        assertEquals(0, Application.matchedCheck(array, lotto, 2));
        assertEquals(1, Application.matchedCheck(array, lotto, 3));
        assertEquals(1, Application.matchedCheck(array, lotto, 4));
        assertEquals(0, Application.matchedCheck(array, lotto, 5));
    }

    @Test
    public void testFormatPrize() {
        assertEquals("1,000", Application.formatPrize(1000));
        assertEquals("20,000", Application.formatPrize(20000));
    }

    @Test
    public void testPrintProfit() {
        Application.printProfit(30000, 50000000);
        assertThat(output()).contains("166,666.7%");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
