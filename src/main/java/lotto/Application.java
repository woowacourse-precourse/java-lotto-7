package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import lotto.Constants.LottoRule;

public class Application {
    public static List<Integer> selectRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange( LottoRule.MIN_NUMBER.getNumber(), LottoRule.MAX_NUMBER.getNumber(), LottoRule.NUM_AMOUNT.getNumber() );
    }
    public static Lotto publishLotto(){
        return new Lotto( selectRandomNumbers() );
    }

    public static int checkAmount( int price ){
        if( price < 1000 || price % 1000 != 0 ) throw new IllegalArgumentException();
        return price / 1000;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
