package lotto.util.function;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoNumberSupplierImpl implements LottoNumberSupplier {

    @Override
    public List<Integer> getLottoNumbers() {
        Set<Integer> nonOverlappingNumbers = new HashSet<>();

        while (nonOverlappingNumbers.size() < LOTTO_SIZE) {
            nonOverlappingNumbers.add(Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER));
        }

       return new ArrayList<>(nonOverlappingNumbers);
    }
}
