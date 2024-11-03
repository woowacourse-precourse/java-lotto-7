package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoHandler {
    private final List<Lotto> purchasedTickets = new ArrayList<>();

    // 티켓 발행 메서드
    public void generateTickets(int purchaseAmount) {
        int numberOfTickets = purchaseAmount / 1000;
        for (int i = 0; i < numberOfTickets; i++) {
            purchasedTickets.add(new Lotto(RandomLottoGenerator.generate()));
        }
    }

    // 구매한 티켓 반환 메서드
    public List<Lotto> getPurchasedTickets() {
        return new ArrayList<>(purchasedTickets);  // 불변 리스트로 반환
    }

    // 당첨 결과 계산 메서드
    public LottoResult calculateResults(List<Integer> winningNumbers, int bonusNumber) {
        LottoResult result = new LottoResult();
        for (Lotto ticket : purchasedTickets) {
            int matchCount = ticket.countMatchingNumbers(winningNumbers);
            boolean bonusMatch = ticket.contains(bonusNumber);
            result.addResult(matchCount, bonusMatch);
        }
        return result;
    }
}
