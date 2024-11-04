package Model;

import Model.Constant.Constants;

import java.util.*;

public class Lotto {
    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validate6numbers(numbers);
        validate1to45(numbers);
        validateNotEqual(numbers);
    }

    private void validate6numbers(List<Integer> numbers) {
        if (numbers.size() != Constants.NUM_COUNT) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_COUNT);
        }
    }

    // TODO: 추가 기능 구현
    private void validate1to45(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < Constants.MIN_NUM || number > Constants.MAX_NUM) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_LOTTO_NUMBER_RANGE);
            }
        }
    }
    private void validateNotEqual(List<Integer> numbers) {
        Set<Integer> numbersNotSame = new HashSet<>();
        for (int number : numbers) {
            if (!numbersNotSame.add(number)) {
                throw new IllegalArgumentException(ErrorMessages.DUPLICATE_LOTTO_NUMBER);
            }
        }
    }

        public int howManySameNumbers (Lotto lotto){
            long sameNumberCount = numbers.stream()
                    .filter(lotto.numbers::contains)
                    .count();

            return (int) sameNumberCount;
        }

        public boolean isContains (BonusNumber bonusNumber){
            return numbers.contains(bonusNumber.get());
        }

        public int getSize () {
            return numbers.size();
        }

        public int getItem ( int idx){
            return numbers.get(idx);
        }

        public List<Integer> getSortedLotto () {
            List<Integer> sortLotto = new ArrayList<>(numbers);
            Collections.sort(sortLotto);
            return sortLotto;
        }

        @Override
        public boolean equals (Object obj){
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Lotto other = (Lotto) obj;
            return numbers.equals(other.numbers);
        }

        @Override
        public int hashCode () {
            return Objects.hash(numbers);
        }
    }
