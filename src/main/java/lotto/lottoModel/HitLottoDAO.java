package lotto.lottoModel;

import java.util.ArrayList;
import java.util.List;

public class HitLottoDAO {
    private List<HitLotto> hitLottos = new ArrayList<>();

    // HitLotto 객체 저장
    public void save(HitLotto hitLotto) {
        hitLottos.add(hitLotto);
    }

    // 모든 HitLotto 객체 조회
    public List<HitLotto> getAll() {
        return new ArrayList<>(hitLottos);
    }

}
