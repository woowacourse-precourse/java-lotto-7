package lotto.lottoModel;

import java.util.ArrayList;
import java.util.List;

public class LottoDAO {

    private List<Lotto> lottoNumbers;

    public LottoDAO() {
        this.lottoNumbers = new ArrayList<>();
    }

    // 데이터베이스에 로또 번호 저장
    public void save(Lotto lotto) {
        lottoNumbers.add(lotto);
    }

    // 모든 로또 번호 리스트 조회
    public List<Lotto> getAll() {
        return new ArrayList<>(lottoNumbers);
    }
}
