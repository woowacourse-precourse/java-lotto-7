package lotto.lottoModel;

import java.util.ArrayList;
import java.util.List;

public class LotteryDAO {
    // 데이터베이스에 로또 번호 저장
    public void save(Lotto lotto) {
        // 구현: 데이터베이스에 로또 객체 저장
    }

    // 데이터베이스에서 로또 번호 조회
    public Lotto find(int id) {
        // 구현: 주어진 ID로 데이터베이스에서 로또 객체 조회
        return null; // 예시 반환값
    }

    // 모든 로또 번호 리스트 조회
    public List<Lotto> findAll() {
        // 구현: 모든 로또 객체를 데이터베이스에서 조회
        return new ArrayList<>(); // 예시 반환값
    }
}
