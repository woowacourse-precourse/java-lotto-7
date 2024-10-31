package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static List<Integer> selectRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange( Constants.MIN_NUMBER, Constants.MAX_NUMBER, Constants.NUM_COUNT );
    }
    public static Lotto publishLotto(){
        return new Lotto( selectRandomNumbers() );
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}
