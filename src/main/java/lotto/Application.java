package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static final String LOTTO_AMOUNT_PHRASE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_COUNT_PHRASE = "개를 구매했습니다.";
    public static final String LOTTO_NUMBER_INPUT = "당첨 번호를 입력해 주세요.";
    public static final String LOTTO_BONUS_INPUT = "보너스 번호를 입력해 주세요.";
    public static final String WIN_STATICS = "당첨 통계\n---";

    public static void main(String[] args) {

    }

    public static Integer checkPurchaseAmount(String input) {
        Integer purchaseAmount = 0;
        try{
            purchaseAmount = Integer.parseInt(input);
        }
        catch(Exception e){
            throw new IllegalArgumentException("잘못된 구입 금액을 입력하셨습니다.");
        }
        return purchaseAmount;
    }

    public static Integer countLotto(Integer input){
        if(input % 1000 != 0){
            throw new IllegalArgumentException("1000원으로 나누어 떨어지는 금액을 입력해주세요.");
        }
        return input/1000;
    }

}
