package lotto.model.strategy;

import java.util.List;

/**
 * 번호 생성 전략 인터페이스
 * 다양한 방식으로 로또 번호를 생성하기 위한 메서드를 정의.
 */
public interface NumberGenerationStrategy {

    /**
     * 1에서 45 사이의 중복되지 않는 정수 6개를 반환합니다.
     * @return 로또 번호 리스트
     */
    List<Integer> generateNumbers();
}
