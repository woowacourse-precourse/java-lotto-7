package lotto.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.factory.LottoFactory;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.LottoWinningNumbers;
import lotto.model.User;

public class LottoService {
    private LottoWinningNumbers winningNumbers;
    private final LottoFactory factory = LottoFactory.getInstance();
    private final List<Lotto> issuedTickets = new ArrayList<>();
    private static final int TICKET_PRICE = 1000;

    public void setWinningNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = new LottoWinningNumbers(winningNumbers, bonusNumber);
    }

    public int calculateTotalSpent(User user) {
        return user.getLottoTickets().size() * TICKET_PRICE; // 티켓 수에 따른 총 비용 계산
    }

    public int convertMoneyToTickets(int money) {
        return money / TICKET_PRICE;
    }


    // 유저에게 로또 티켓을 제공하는 메서드
    public void provideLottoTickets(User user, int ticketCount) {
        List<Lotto> lottoTickets = generateLottoTickets(ticketCount);
        issuedTickets.addAll(lottoTickets); // 발행된 티켓 목록에 추가
        user.addLottoTickets(Collections.unmodifiableList(lottoTickets)); // 유저에게 반환할 때는 불변 리스트로 반환
    }


    // 로또 티켓을 생성하는 메서드
    private List<Lotto> generateLottoTickets(int ticketCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            Lotto newTicket = factory.createLotto(); // 로또 생성
            lottoTickets.add(newTicket);
        }
        return lottoTickets; // 생성된 티켓 목록 반환
    }

    public LottoWinningNumbers getWinningNumbers() {
        return winningNumbers;
    }


    // 매칭 결과를 누적하여 통계를 바로 계산하는 방식
    public Map<LottoRank, Integer> calculateResults() {
        Map<LottoRank, Integer> results = LottoRank.initRankMap();

        for (Lotto ticket : issuedTickets) {
            int matchCount = calculateMatchCount(ticket);
            boolean bonusMatch = checkBonusMatch(ticket);
            LottoRank rank = calculateRank(matchCount, bonusMatch);
            updateResults(results, rank);
        }

        return Collections.unmodifiableMap(results);
    }

    private int calculateMatchCount(Lotto ticket) {
        return ticket.checkMatch(winningNumbers.getWinningNumbers());
    }

    private boolean checkBonusMatch(Lotto ticket) {
        return ticket.isBonusMatch(winningNumbers.getBonusNumber());
    }

    private LottoRank calculateRank(int matchCount, boolean bonusMatch) {
        return LottoRank.getRank(matchCount, bonusMatch);
    }

    private void updateResults(Map<LottoRank, Integer> results, LottoRank rank) {
        results.put(rank, results.get(rank) + 1);
    }

    public double calculateProfitRate(Map<LottoRank, Integer> results, int totalSpent) {
        int totalEarnings = 0;

        // 각 등급의 당첨금을 계산하여 totalEarnings에 합산
        for (Map.Entry<LottoRank, Integer> entry : results.entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            totalEarnings += rank.getPrize() * count;
        }

        // 수익률 계산: (총 당첨금 / 총 지출금) * 100
        return ((double) totalEarnings / totalSpent) * 100;
    }
}
