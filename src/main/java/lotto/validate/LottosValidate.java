package lotto.validate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottosValidate {

    public static boolean isAscendingNumber(List<Integer> list) {
        List<Integer> ascendingList = new ArrayList<>(list);
        Collections.sort(list);

        return ascendingList.equals(list);
    }
}
