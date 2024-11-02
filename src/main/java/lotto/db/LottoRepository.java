package lotto.db;

import java.util.List;
import lotto.Lotto;

public class LottoRepository {

    private static LottoRepository lottoRepository;

    private List<Lotto> buyerLotties;
    private Lotto winningLotto;
    private int bonus;

    private LottoRepository() {}

    public static LottoRepository getInstance() {
        if (lottoRepository == null) {
            lottoRepository = new LottoRepository();
            return lottoRepository;
        }
        return lottoRepository;
    }

    public List<Lotto> save(List<Lotto> buyerLotties) {
        return this.buyerLotties = buyerLotties;
    }

    public Lotto save(Lotto winningLotto) {
        return this.winningLotto = winningLotto;
    }

    public int save(int bonus) {
        return this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    public List<Lotto> getBuyerLotties() {
        return buyerLotties;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }
}
