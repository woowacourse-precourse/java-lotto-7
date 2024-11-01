package lotto.view;

import lotto.model.InputModel;
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
        System.out.println(userLotto.getNumberOfLotto()+"개를 구매했습니다.");
        outputModel.showUserLotto(userLotto);
    }
}
