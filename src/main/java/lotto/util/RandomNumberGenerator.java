package lotto.util;


import java.util.List;

public interface RandomNumberGenerator {

    List<Integer> generateUniqueNumbersInRange(int startInclusive, int endInclusive, int numberCount);

}
