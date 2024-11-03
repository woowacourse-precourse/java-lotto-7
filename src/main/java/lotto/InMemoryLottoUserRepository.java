package lotto;

import java.util.ArrayList;
import java.util.List;

public class InMemoryLottoUserRepository implements LottoUserRepository {

    private static final InMemoryLottoUserRepository INSTANCE = new InMemoryLottoUserRepository();

    private final List<LottoUser> lottoUsers = new ArrayList<>();

    private InMemoryLottoUserRepository() {

    }

    public static InMemoryLottoUserRepository getInstance() {
        return INSTANCE;
    }

    @Override
    public void save(LottoUser lottoUser) {
        lottoUsers.add(lottoUser);
    }
}
