package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String readMoney(){
        System.out.println(INPUT_MONEY);
        String money = Console.readLine();
        return money;
    }

    public String readLottoNum(){
        System.out.println();
        System.out.println(INPUT_LOTTO_NUMBER);
        String lottoNum = Console.readLine();
        return lottoNum;
    }

    public String readBonusNum() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER);
        String bonusNum = Console.readLine();
        return bonusNum;
    }
}
