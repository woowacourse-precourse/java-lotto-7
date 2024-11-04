package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class NumberList extends ArrayList<Integer> {

    public static final int[] NUMBER_RANGE = {1,45};
    public static final int NUMBER_RANGE_START = 0;
    public static final int NUMBER_RANGE_END = 1;

    public static final int  MAX_SIZE = 6;

    public NumberList(){
        super();
    }

    static public void validateLottoNumbersSize(List<Integer> list){
        Validator.validateListSize(list,MAX_SIZE);
    }

    static public void validateLottoNumberRange(int number){
        int startRange = NUMBER_RANGE[NumberList.NUMBER_RANGE_START];
        int endRange = NUMBER_RANGE[NumberList.NUMBER_RANGE_END];
        Validator.validateSpecificRange(number, startRange,endRange);
    }

    public NumberList generateRandomNumberList(){

        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange( NUMBER_RANGE[NUMBER_RANGE_START], NUMBER_RANGE[NUMBER_RANGE_END],MAX_SIZE);

        this.addAll(randomNumbers);

        return sortAscending();
    }

    public NumberList sortAscending() {
        this.sort(Comparator.naturalOrder());

        return this;
    }
}
