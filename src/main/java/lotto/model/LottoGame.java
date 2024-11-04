package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> tickets = new ArrayList<>();
    private Lotto winningNumber;
    private int bonusNumber;

    public void purchaseTicket(int amount) {
        validate(amount);
        int count = amount / 1000;
        for (int i = 0; i < count; i++) {
            // 로또 생성 메소드
            tickets.add(generate());
        }
    }

    private void validate(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력 해야 합니다.");
        }
    }

    private Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public void setWinningNumber(List<Integer> number) {
        winningNumber = new Lotto(number);
    }

    public void setBonusNumber(int number) {
        this.bonusNumber = number;
    }

    public List<Lotto> getTickets() {
        return tickets;
    }

    public LottoResult calculateResult() {
        LottoResult result = new LottoResult();

        for (Lotto ticket : tickets) {
            int matchCount = ticket.matchCount(winningNumber);
            boolean bonusCheck = ticket.getNumbers().contains(bonusNumber);
            WinningRank winningRank = WinningRank.matchRank(matchCount, bonusCheck);
            if (winningRank != null) {
                result.record(winningRank);
            }
        }
        return result;
    }
}
