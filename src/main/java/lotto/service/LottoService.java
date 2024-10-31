package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoWinningNumbers;

public class LottoService {
    private final List<Lotto> lottoTickets = new ArrayList<>();
    private LottoWinningNumbers winningLotto;

    public void issueLottoTickets(int money) {
        for (int i = 0; i < money; i++) {
            lottoTickets.add(new Lotto(generateLottoNumbers()));
        }

    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        sortLottoNumbers(numbers);
        return numbers;
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
        return numbers;
    }
}
