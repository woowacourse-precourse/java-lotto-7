package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoIssuanceService {
    public List<Integer> lottoNumbers;  // 로또 번호 저장할 리스트

    // 로또 번호 생성 메소드
    public void randomLottoIssue() {
        this.lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    // 로또 번호 오름차순 출력 메소드
    public void printIssuedLottoNumbers() {
        lottoNumbers.sort(Integer::compareTo);  // 오름차순 정렬
        this.lottoNumbers = lottoNumbers;       // 오름차순 저장
        System.out.println(this.lottoNumbers);  // 정렬된 리스트 출력
    }
}