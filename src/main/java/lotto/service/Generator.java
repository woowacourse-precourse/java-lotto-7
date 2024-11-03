package lotto.service;

import java.util.List;
import lotto.model.Lotto;

public interface Generator {
    Lotto generate();

    List<Lotto> generates(int count);
}
