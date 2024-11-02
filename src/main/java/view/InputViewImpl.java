package view;

import camp.nextstep.edu.missionutils.Console;

public class InputViewImpl implements InputView {
    @Override
    public String inputMoney() {

        System.out.println("구입금액을 입력해 주세요.");

        return Console.readLine();
    }

    @Override
    public String inputLottoWinningResult() {
        return null;
    }
}
