package lotto.repository;
import java.util.List;
public class LottoRepository {
    private final List<List<Integer>> userLotto;

    public LottoRepository(List<List<Integer>> userLotto){
        this.userLotto = userLotto;
    }

}
