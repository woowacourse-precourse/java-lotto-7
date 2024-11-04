package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import lotto.util.Config;

public class LottoService {
    private final List<Lotto> lottoTickets = new ArrayList<>();
    private WinningLotto winningLotto;

    // 로또 티켓 발행 (구입 금액에 따라 생성)
    public void issueLottoTickets(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(new Lotto(generateLottoNumbers()));
        }
    }

    // 로또 번호 생성 (1부터 45까지 중복 없는 6개의 번호)
    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        numbers.sort(Integer::compareTo);
        return numbers;
    }

    // 당첨 번호 설정
    public void setWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    // 당첨 번호의 형식을 검증하고 파싱하는 메서드
    public List<Integer> parseWinningNumbers(String input) {
        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (String num : numberStrings) {
            try {
                int number = Integer.parseInt(num.trim());
                if (number < 1 || number > 45) {
                    throw new IllegalArgumentException(Config.ERROR_OUT_OF_RANGE_NUMBER);
                }
                if (!uniqueNumbers.add(number)) {
                    throw new IllegalArgumentException(Config.ERROR_DUPLICATE_NUMBER);
                }
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(Config.ERROR_INVALID_NUMBER_FORMAT);
            }
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Config.ERROR_INVALID_WINNING_NUMBER_COUNT);
        }

        return numbers;
    }

    // 당첨 결과 계산
    public List<Rank> calculateResults() {
        List<Rank> results = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            int matchCount = countMatchingNumbers(lotto);
            boolean bonusMatch = isBonusNumberMatch(lotto);
            results.add(Rank.valueOf(matchCount, bonusMatch));
        }
        return results;
    }

    // 일치하는 번호 개수 계산
    private int countMatchingNumbers(Lotto userLotto) {
        return (int) userLotto.getNumbers().stream()
                .filter(winningLotto.getWinningLotto().getNumbers()::contains)
                .count();
    }

    // 보너스 번호 일치 여부 확인
    private boolean isBonusNumberMatch(Lotto userLotto) {
        return userLotto.getNumbers().contains(winningLotto.getBonusNumber());
    }

    // 수익률 계산
    public double calculateYield(int moneySpent) {
        List<Rank> results = calculateResults();
        int totalPrize = results.stream().mapToInt(Rank::getPrize).sum();
        return ((double) totalPrize / moneySpent) * 100; // 수익률 계산
    }

    // 생성된 로또 티켓 가져오기
    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
