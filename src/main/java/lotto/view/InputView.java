package lotto.view;

import static lotto.util.LottoUtil.parseAndValidateBonusNumber;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputUserForData() {
        return Console.readLine();
    }

    public int inputBonusNumber() {
        return parseAndValidateBonusNumber(Console.readLine());
    }

}
