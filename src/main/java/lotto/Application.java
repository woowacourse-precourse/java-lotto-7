package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static final String LOTTO_AMOUNT_PHRASE = "구입금액을 입력해 주세요.";
    public static final String LOTTO_COUNT_PHRASE = "개를 구매했습니다.";
    public static final String LOTTO_NUMBER_INPUT = "당첨 번호를 입력해 주세요.";
    public static final String LOTTO_BONUS_INPUT = "보너스 번호를 입력해 주세요.";
    public static final String WIN_STATICS = "당첨 통계\n---";
    public static final String COMMA = ",";

    public static void main(String[] args) {

    }

    public static Integer parseInt(String input) {
        Integer result;
        try{
            result = Integer.parseInt(input);
        }
        catch(Exception e){
            throw new IllegalArgumentException("잘못된 숫자를 입력하셨습니다.");
        }
        return result;
    }

    public static Integer countLotto(Integer input){
        if(input % 1000 != 0){
            throw new IllegalArgumentException("1000원으로 나누어 떨어지는 금액을 입력해주세요.");
        }
        return input/1000;
    }

    public static boolean checkLottoRange(Integer input){
        if(input >= 1 && input <= 45) return true;
        return false;
    }


}
