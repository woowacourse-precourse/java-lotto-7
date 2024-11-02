package lotto.model.util;

import java.util.List;

public interface RandomUtil {

    public List<Integer> issueLottoTicket(Integer minNumber, Integer maxNumber, Integer lottoCount);
}
