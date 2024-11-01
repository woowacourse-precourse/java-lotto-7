package lotto.view;

import java.util.List;
import lotto.model.InputModel;
import lotto.model.Lotto;
import lotto.model.OutputModel;
import lotto.model.UserLotto;

public class LottoView {
    InputModel inputModel;
    OutputModel outputModel;

    public LottoView() {
        inputModel = new InputModel();
        outputModel = new OutputModel();
    }

    public int inputPriceView() {
        System.out.println("구입금액을 입력해 주세요.");
        return (inputModel.getPrice())/1000;
    }

    public void outputUserLottoView(UserLotto userLotto) {
        System.out.println("\n" + userLotto.getNumberOfLotto() + "개를 구매했습니다.");
        outputModel.showUserLotto(userLotto);
    }

    public Lotto inputWinningNumbersView() {
        Lotto winningNumbers;
        System.out.println("\n당첨 번호를 입력해 주세요.");
        winningNumbers = inputModel.getWinningNumbers();
        return winningNumbers;
    }
}
