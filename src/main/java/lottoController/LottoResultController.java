package lottoController;

import lotto.Lotto;
import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class LottoResultController {

    private static Lotto winningNumber;
    private static int bonusNumber;

    public void checkLottoResult() {
        saveWinningNumber(InputView.inputWinningNumber());
        saveBonusNumber();
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

    public void saveBonusNumber() {
        try {
            bonusNumber = Integer.parseInt(InputView.inputBonusNumber());

            if(bonusNumber > 45 || bonusNumber < 1){
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
            }

        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERORR] 숫자만 입력 가능 합니다.");
        }
    }
}
