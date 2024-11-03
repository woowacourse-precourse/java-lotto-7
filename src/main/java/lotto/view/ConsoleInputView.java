package lotto.view;

import camp.nextstep.edu.missionutils.Console;

/** 입력값을 받아서 반환한다. */
public class ConsoleInputView implements InputView {
    
    private static final String ENTER_MONEY_BUY_LOTTO = "구입금액을 입력해주세요.";
    
    private static final String ENTER_WINNER_LOTTO_NUMBER = "당첨 번호를 입력해주세요";
    
    private static final String ENTER_BONUS_LOTTO_NUMBER = "보너스 번호를 입력해주세요";
    
    @Override
    public String getBuyingMoney() {
        System.out.println(ENTER_MONEY_BUY_LOTTO);
        return Console.readLine();
    }
    
    @Override
    public String getWinNumbers() {
        System.out.println();
        System.out.println(ENTER_WINNER_LOTTO_NUMBER);
        return Console.readLine();
    }
    
    @Override
    public String getBonusNumber() {
        System.out.println();
        System.out.println(ENTER_BONUS_LOTTO_NUMBER);
        return Console.readLine();
    }

}
