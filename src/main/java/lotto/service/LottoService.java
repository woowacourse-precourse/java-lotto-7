package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningLotto;
import lotto.util.Validator;

public class LottoService {
    private final List<Lotto> lottoTickets = new ArrayList<>();
    private WinningLotto winningLotto;

    // 구입한 로또 티켓 발행
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

    // 당첨 번호와 보너스 번호 설정
    public void setWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningLotto = new WinningLotto(winningNumbers, bonusNumber);
    }

    // 문자열 입력된 당첨 번호를 파싱하여 리스트로 변환
    public List<Integer> parseWinningNumbers(String input) {
        String[] numberStrings = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String num : numberStrings) {
            int number = Validator.validateAndParseNumber(num.trim());
            numbers.add(number);
        }

        Validator.validateLottoNumberCount(numbers);
        Validator.validateLottoNumberRange(numbers);
        Validator.validateLottoNumberDuplication(numbers);

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

    // 수익률 계산
    public double calculateYield(int moneySpent) {
        List<Rank> results = calculateResults();
        int totalPrize = results.stream().mapToInt(Rank::getPrize).sum();
        return ((double) totalPrize / moneySpent) * 100;
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

    // 생성된 로또 티켓 목록 반환
    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }
}
