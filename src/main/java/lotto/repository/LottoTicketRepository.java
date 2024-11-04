package lotto.repository;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import lotto.domain.GameStatus;
import lotto.domain.Lotto;

public class LottoTicketRepository {

    private static LottoTicketRepository instance;
    private static Deque<Lotto> lottoReceipt;
    private static Long totalGameCount = GameStatus.LOWEST_GAME_COUNT.get();

    private LottoTicketRepository() {
        lottoReceipt = new ArrayDeque<>();
    }

    public void fillReceipt(Lotto lotto) {
        lottoReceipt.add(lotto);
        totalGameCount += GameStatus.ADDED_GAME_COUNT.get();
    }

    public List<Lotto> getReceipt() {
        return lottoReceipt.stream().toList();
    }

    public List<Integer> getGame() {
        return lottoReceipt.removeFirst().getNumbers();
    }

    public Long getTotalGameCount() {
        return totalGameCount;
    }

    public Boolean unrevealedGameExist() {
        return !lottoReceipt.isEmpty();
    }

    public Integer unrevealedGameCount() {
        return lottoReceipt.size();
    }

    public static LottoTicketRepository getTicket() {
        if (instance == null) {
            instance = new LottoTicketRepository();
            return instance;
        }
        return instance;
    }
}