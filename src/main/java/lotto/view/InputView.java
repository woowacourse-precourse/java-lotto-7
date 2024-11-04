package lotto.view;

import static lotto.constant.LottoConstant.LOTTO_NUM_DELIMITER;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String[] getWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");

        return Console.readLine().split(LOTTO_NUM_DELIMITER);
    }

    public String getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }


}
