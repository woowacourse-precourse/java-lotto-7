package lotto.domain;

import java.util.List;

public interface CriteriaTool {
    Long matchingMainNumbers(List<Integer> lotto);
    Boolean matchingLuckyNumber(List<Integer> lotto);
}