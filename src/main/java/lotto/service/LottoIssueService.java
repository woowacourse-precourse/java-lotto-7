package lotto.service;

import java.util.List;
import lotto.model.db.Lotto;

public interface LottoIssueService {

    int MIN_LOTTO_NUM = 1;
    int MAX_LOTTO_NUM = 45;
    int LOTTO_NUM_SIZE = 6;

    List<Lotto> issue(String prompt, int lottoCnt);

    Lotto issue(String prompt);
}
