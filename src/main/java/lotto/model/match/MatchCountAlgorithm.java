package lotto.model.match;

import java.util.List;

/**
 * 두 개의 동일한 유형(Number 및 하위)의 리스트를 인자로 받아
 * 일치하는 요소의 개수를 반환하는 알고리즘을 정의하는 인터페이스입니다.
 *
 * @param <T> 일치하는 요소의 타입 (Number 서브타입)
 * @see Number
 */
public interface MatchCountAlgorithm<T extends Number> {

    int countMatches(List<T> list, List<T> list2);
}
