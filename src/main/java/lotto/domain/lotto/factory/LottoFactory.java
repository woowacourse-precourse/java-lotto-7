package lotto.domain.lotto.factory;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoEntry;

import java.util.List;

public interface LottoFactory {

    List<LottoEntry> create();

    int getLottoLength();

}
