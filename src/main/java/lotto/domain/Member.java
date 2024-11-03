package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Member {

    private static final Member instance = new Member();
    private final List<Lotto> issuedLottos;

    private Member() {
        issuedLottos = new ArrayList<>();
    }

    public static Member getInstance() {
        return instance;
    }

    public void saveIssuedLotto(Lotto lotto) {
        issuedLottos.add(lotto);
    }

    public List<Lotto> getIssuedLottos() {
        return issuedLottos;
    }
}
