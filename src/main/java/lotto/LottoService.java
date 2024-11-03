package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoService {
    public List<Integer> lottoNumbers;  // 로또 번호 저장할 리스트

    // 로또 번호 생성 메소드
    public List<Integer> randomLottoIssue() {
        this.lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }

    // 로또 번호 출력 메소드
    public void printIssuedLottoNumbers(List<Integer> lottoNumbers) {
        lottoNumbers.sort(Integer::compareTo);  // 오름차순 정렬
        System.out.println(lottoNumbers);
    }
}