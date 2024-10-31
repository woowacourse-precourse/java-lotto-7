package lotto.lottoModel;

import java.util.ArrayList;
import java.util.List;

public class HitLottoDAO {
    private List<HitLotto> hitLottoNumbers;

    public HitLottoDAO() {
        this.hitLottoNumbers = new ArrayList<>();
    }

    // 데이터베이스에 로또 번호 저장
    public void save(HitLotto hitLotto) {
        hitLottoNumbers.add(hitLotto);
    }

    // 모든 로또 번호 리스트 조회
    public List<HitLotto> getAll() {
        return new ArrayList<>(hitLottoNumbers); // 예시 반환값
    }
}
