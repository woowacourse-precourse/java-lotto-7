package lotto.model;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import lotto.Lotto;
import lotto.utils.ErrorMessages;

public class LottoResultCalculator {
    private static final int LOTTO_NUMBER_MIN = 1;
    private static final int LOTTO_NUMBER_MAX = 45;

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    /**
     * LottoResultCalculator 생성자
     * @param winningNumbers 당첨 번호 리스트
     * @param bonusNumber 보너스 번호
     */
    public LottoResultCalculator(
            List<Integer> winningNumbers,
            int bonusNumber
    ) {
        validateBonusNumber(bonusNumber);
        this.winningNumbers = List.copyOf(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    /**
     * 당첨 결과 계산 메서드
     * @param tickets 사용자가 구입한 로또 티켓 목록
     * @return 등수별 당첨 횟수를 담은 Map
     */
    public Map<LottoRank, Integer> calculateResults(List<Lotto> tickets) {
        Map<LottoRank, Integer> result = new HashMap<>();

        for (Lotto ticket : tickets) {
            LottoRank rank = calculateRank(ticket);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    /**
     * 로또 티켓에 대한 등수 계산
     * @param ticket 로또 티켓
     * @return 계산된 LottoRank
     */
    private LottoRank calculateRank(Lotto ticket) {
        int matchCount = countMatchingNumbers(ticket);
        boolean matchBonus = ticket.getNumbers().contains(bonusNumber);

        return LottoRank.valueOf(matchCount, matchBonus);
    }

    /**
     * 로또 티켓의 번호와 당첨 번호 일치 개수 계산
     * @param ticket 로또 티켓
     * @return 일치하는 번호 개수
     */
    private int countMatchingNumbers(Lotto ticket) {
        return (int) ticket.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    /**
     * 보너스 번호의 유효성 검증
     * @param bonusNumber 보너스 번호
     */
    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LOTTO_NUMBER_MIN || bonusNumber > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException(ErrorMessages.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}