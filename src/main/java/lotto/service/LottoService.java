package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.WinningLotto;

public class LottoService {
    private final List<Lotto> lottoTickets = new ArrayList<>();
    private WinningLotto winningLotto;

    public void issueLottoTickets(int money) {
        for (int i = 0; i < money; i++) {
            lottoTickets.add(new Lotto(generateLottoNumbers()));
        }
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6)); // 복사하여 수정 가능한 리스트로 변환
        sortLottoNumbers(numbers);
        return numbers;
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers) {
        numbers.sort(Integer::compareTo);
        return numbers;
    }

    public void setWinningNumbers(String winningNumbers, int bonusNumber) {
        List<Integer> winningNumberList = parseWinningNumbers(winningNumbers);
        this.winningLotto = new WinningLotto(winningNumberList, bonusNumber);
    }

    private List<Integer> parseWinningNumbers(String winningNumbers) {
        String[] numberStrings = winningNumbers.split(",");
        List<Integer> numbers = new ArrayList<>();
        for (String num : numberStrings) {
            numbers.add(Integer.parseInt(num.trim()));
        }
        return numbers;
    }


}
