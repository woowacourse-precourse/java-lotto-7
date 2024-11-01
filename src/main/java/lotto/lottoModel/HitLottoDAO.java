package lotto.lottoModel;

import java.util.ArrayList;
import java.util.List;


public class HitLottoDAO {
    private List<HitLotto> hitLottos = new ArrayList<>();

    // HitLotto 객체 저장
    public HitLottoDTO getAsDTO() {
        HitLotto hitLotto = HitLotto.getInstance(null, 0);  // 이미 초기화된 싱글톤 인스턴스를 가져옴
        return new HitLottoDTO(hitLotto.getAllHitNumbers());
    }

}
