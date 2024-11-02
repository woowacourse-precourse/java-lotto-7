package lotto.service;

import java.util.List;
import lotto.Lotto;

public interface LottoIssueService {
    List<Lotto> issue(int lottoCnt);
}
