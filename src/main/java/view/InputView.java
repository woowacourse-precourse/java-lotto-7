package view;

import model.Lotto;

public interface InputView {

    public String inputMoney();

    public String inputWinningNumbers();

    public String inputBonusNumber(Lotto lotto);
}
