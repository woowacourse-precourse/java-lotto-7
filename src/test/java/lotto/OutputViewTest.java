package lotto;

import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class OutputViewTest{
    @Test
    public void 로또_출력_테스트() {
        String input = "2000\n1,2,3,4,5,6\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        outputView.generateLotto(inputView.getLottoCount());
        inputView.inputStart(outputView);

        List<List<Integer>> outputLottoNumbers = outputView.getBoughtLottoNumbers();

        assertEquals(8000, inputView.getLottoPurchase());
        assertEquals(outputLottoNumbers.size(),8);
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5, 6}, inputView.getLottoNumbers().toArray(new Integer[0]));
        assertEquals(7, inputView.getBonusNumber());
    }
}