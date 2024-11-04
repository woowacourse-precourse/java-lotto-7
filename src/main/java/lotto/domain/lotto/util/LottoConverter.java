package lotto.domain.lotto.util;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.lotto.domain.Lotto;
import lotto.domain.lotto.domain.LottoNumber;

public final class LottoConverter {

    private LottoConverter() {
        throw new IllegalStateException("유틸리티 클래스는 인스턴스화할 수 없습니다.");
    }

    public static List<Lotto> convertToLottos(List<List<Integer>> numbers) {
        return numbers.stream()
                .map(Lotto::from)
                .collect(Collectors.toList());
    }

    public static List<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList());
    }


}
