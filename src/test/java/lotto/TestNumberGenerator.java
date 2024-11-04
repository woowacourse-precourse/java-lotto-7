package lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.generator.NumberGenerator;

public class TestNumberGenerator implements NumberGenerator {

    private final List<List<Integer>> testNumbers;
    private int index = 0;

    /**
     * 미리 정의된 로또 번호 리스트를 받아 내부에 저장한다
     *
     * @param testNumbers 테스트에서 사용할 로또 번호들의 리스트
     */
    public TestNumberGenerator(List<List<Integer>> testNumbers) {
        this.testNumbers = new ArrayList<>(testNumbers);
    }

    /**
     * 호출될 때마다 미리 정의된 로또 번호를 순서대로 반환한다
     * 모든 번호를 다 반환하면 IllegalStateException을 발생시킨다
     *
     * @return 미리 정의된 로또 번호 리스트 중 하나
     * @throws IllegalStateException 더 이상 반환할 번호가 없을 때 발생
     */
    @Override
    public List<Integer> generateNumber() {
        if (index < testNumbers.size()) {
            return testNumbers.get(index++);
        }
        throw new IllegalStateException("더 이상 생성할 번호가 없다.");
    }
}
