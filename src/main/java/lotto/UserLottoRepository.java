package lotto;

import java.util.ArrayList;
import java.util.List;

public class UserLottoRepository {
    private final List<Lotto> userLottos = new ArrayList<>();

    public void save(Lotto lotto) {
        userLottos.add(lotto);
    }

    public List<Lotto> getAll() {
        return userLottos;
    }


}
