package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현

    /**
     * 입력받은 로또 당첨번호와 비교하여 등수를 계산합니다.
     *
     * @param gradingNumbers 비교대상이 될 로또 당첨번호
     * @param bonusNumber    비교대상이 될 로또 보너스번호
     * @return 로또 당첨등수. 당첨되지 않은 경우 -1을 반환합니다.
     */
    public int grade(List<Integer> gradingNumbers, int bonusNumber) {
        int[] compareResult = getSameNumberCount(gradingNumbers, bonusNumber);
        int sameCount = compareResult[0];
        boolean isBonusInclude = compareResult[1] == 1;

        if (sameCount == 5) {
            if (!isBonusInclude) return 3;
            return 2;
        }
        return LottoConstant.LOTTO_GRADES[sameCount];
    }

    /**
     * 로또 당첨번호와 보너스번호가 현재 로또의 번호와 몇개 일치하는지 판단합니다.
     *
     * @param gradingNumbers 비교대상이 될 로또 당첨번호
     * @param bonusNumber    비교대상이 될 로또 보너스번호
     * @return 길이 2인 배열의 0번째에는 일치하는 번호의 개수, 1번째에는 보너스번호의 일치여부가 담겨 반환됩니다.
     */
    private int[] getSameNumberCount(List<Integer> gradingNumbers, int bonusNumber) {
        int gradingNumbersPointer = 0, numbersPointer = 0;
        int sameCount = 0, isBonusInclude = 0;
        List<Integer> orderedNumbers = this.getSortedNumbers();
        while (numbersPointer < orderedNumbers.size() && gradingNumbersPointer < gradingNumbers.size() ) {
            int gradeNumber = gradingNumbers.get(gradingNumbersPointer);
            int compareNumber = orderedNumbers.get(numbersPointer);

            if (gradeNumber == compareNumber) sameCount++;
            if (bonusNumber == compareNumber) isBonusInclude = 1;


            if (gradeNumber >= compareNumber) numbersPointer++;
            if (gradeNumber <= compareNumber) gradingNumbersPointer++;
        }

        return new int[]{sameCount, isBonusInclude};
    }

    /**
     * 담겨있는 로또번호들을 정렬하여 반환합니다. 원본은 정렬되지 않습니다.
     *
     * @return 정렬된 로또번호 리스트
     */
    public List<Integer> getSortedNumbers() {
        List<Integer> orderedNumbers = new ArrayList<>(this.numbers);
        orderedNumbers.sort(Integer::compareTo);
        return orderedNumbers;
    }

    @Override
    public String toString() {
        List<Integer> sortedNumbers = this.getSortedNumbers();
        return sortedNumbers.toString();
    }
}
