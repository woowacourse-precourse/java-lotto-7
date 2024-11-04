package lotto.model.strategy;

import java.util.Arrays;
import java.util.List;

/**
 * 고정 번호 생성 클래스
 * NumberGenerationStrategy 인터페이스를 구현하여, 테스트용 고정된 로또 번호를 반환.
 */
public class FixedNumberGeneration implements NumberGenerationStrategy{

    /**
     * 고정된 로또 번호 리스트 반환
     * 테스트 목적으로 사용되며, 항상 동일한 번호를 반환
     * @return 고정된 로또 번호 리스트
     */
    @Override
    public List<Integer> generateNumbers() {
        return Arrays.asList(1,2,3,4,5,6);
    }
}
