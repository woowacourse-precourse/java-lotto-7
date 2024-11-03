package lotto.model.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

/**
 * 랜덤 번호 생성 클래스
 * NumberGenerationStrategy 인터페이스를 구현하여,
 * 1에서 45 사이의 중복되지 않는 6개의 숫자를 생성.
 */
public class RandomNumberGeneration implements NumberGenerationStrategy{

    /**
     * 1에서 45 사이의 중복되지 않는 정수 6개를 랜덤하게 생성하여 반환
     * @return 로또 번호 리스트
     */
    @Override
    public List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
