package lotto;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class InputViewTest {
    @Test
    public void 로또_입력_테스트() {
        String input = "10000\n1,2,3,4,5,6\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView();

        assertEquals(10000, inputView.getLottoPurchase());
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, inputView.getLottoNumbers().toArray(new Integer[0]));
        assertEquals(7, inputView.getBonusNumber());
    }
}