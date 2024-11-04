package lotto.application;

import java.util.List;
import lotto.domain.Lotto;

public interface RetrieveLottoUseCase {

    List<Lotto> retrieveAll();
}
