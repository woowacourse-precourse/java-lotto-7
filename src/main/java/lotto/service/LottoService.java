package lotto.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.User;

public class LottoService {
    private final LottoNumberGenerator numberGenerator;
    private final List<Lotto> issuedTickets = new ArrayList<>();

    public LottoService(LottoNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;


    }

    // 로또 번호 설정
    public void setExtra(List<Integer> winningNumbers, int bonusNumber) {
        numberGenerator.setWinningNumbers(winningNumbers);
        numberGenerator.setBonusNumber(bonusNumber);
    }

    // 새로운 로또 티켓 생성 및 발행
    public Lotto createLottoTicket() {
        Lotto newTicket = new Lotto(numberGenerator.generateNumbers());
        issuedTickets.add(newTicket);  // 전체 발행 목록에 추가
        return newTicket;
    }


    // 유저에게 로또 티켓을 제공하고 저장
    public void provideLottoTickets(User user, int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            Lotto newTicket = createLottoTicket();
            user.addLottoTicket(newTicket);  // 유저의 티켓 목록에 추가
        }
    }


    public Map<Lotto, Map<String, Object>> checkMatches(List<Integer> winningNumbers, int bonusNumber) {
        Map<Lotto, Map<String, Object>> matchResults = new HashMap<>();
        for (Lotto ticket : issuedTickets) {  // 로또서비스가 가진 모든 로또 티켓 가져오기
            int matchCount = Lotto.checkMatch(ticket, winningNumbers);
            boolean bonusMatch = Lotto.isBonusMatch(ticket, bonusNumber);
            matchResults.put(ticket, createMatchResult(matchCount, bonusMatch));  // 티켓과 결과 매핑
        }
        return matchResults;
    }

    private Map<String, Object> createMatchResult(int matchCount, boolean bonusMatch) {
        Map<String, Object> result = new HashMap<>();
        result.put("matchCount", matchCount);
        result.put("bonusMatch", bonusMatch);
        return result;
    }

    public List<Integer> getLottoNumbers() { // 가장 마지막에 생성된 로또번호
        return numberGenerator.getLottoNumbers();
    }

    public List<Integer> getWinningNumbers() {
        return numberGenerator.getWinningNumbers();
    }

    public int getBonusNumbers() {
        return numberGenerator.getBonusNumbers();
    }


}
