package lotto.util.function;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoNumberSupplierImpl implements LottoNumberSupplier {

    @Override
    public List<Integer> getLottoNumbers() {

       return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, 6);
    }
}
