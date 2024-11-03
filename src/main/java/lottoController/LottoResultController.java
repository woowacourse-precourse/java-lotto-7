package lottoController;

import lotto.Lotto;
import view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoResultController {

    private static Lotto winningNumber;
    private static int bonusNumber;

    public void checkLottoResult() {
        saveWinningNumber(InputView.inputWinningNumber());
    }

    public void saveWinningNumber(String InputWinningNumber) {
        String[] stringWinningNumber = InputWinningNumber.split(",");
        List<Integer> validWinningNumber = new ArrayList<>();

        try {
            for(String number : stringWinningNumber){
                validWinningNumber.add(Integer.parseInt(number));
            }
            winningNumber = new Lotto(validWinningNumber);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERORR] 숫자만 입력 가능 합니다.");
        }
    }
}
