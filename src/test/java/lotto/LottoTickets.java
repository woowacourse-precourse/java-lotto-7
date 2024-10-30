package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoConstant;

public class LottoTickets {
    List<Lotto> tickets;

    public LottoTickets(List<Lotto> tickets) {
        validate(tickets);
        this.tickets = tickets;
    }

    public int size() {
        return this.tickets.size();
    }
    private void validate(List<Lotto> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 정상적으로 로또 번호가 생성되지 못하였습니다.");
        }
    }

}
