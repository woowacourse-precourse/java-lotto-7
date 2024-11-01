package lotto.repository;
import java.util.List;
public class Lotto {
    private final List<List<Integer>> userLotto;

    public Lotto(List<List<Integer>> userLotto){
        this.userLotto = userLotto;
    }

}
