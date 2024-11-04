package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;
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

    private int countMatchingNumbers(Lotto userLotto) {
        return (int) userLotto.getNumbers().stream()
                .filter(winningLotto.getWinningLotto().getNumbers()::contains)
                .count();
    }

    // 보너스 번호 일치 여부 확인
    private boolean isBonusNumberMatch(Lotto userLotto) {
        return userLotto.getNumbers().contains(winningLotto.getBonusNumber());
    }

    public List<Rank> calculateResults() {
        List<Rank> results = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            int matchCount = countMatchingNumbers(lotto);
            boolean bonusMatch = isBonusNumberMatch(lotto);
            results.add(Rank.valueOf(matchCount, bonusMatch));
        }
        return results;
    }

    // 수익률 계산
    public double calculateYield(int moneySpent) {
        List<Rank> results = calculateResults();
        int totalPrize = results.stream().mapToInt(Rank::getPrize).sum();
        return ((double) totalPrize / moneySpent) * 100;
    }

    // 생성된 로또 티켓 가져오기
    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }


}
