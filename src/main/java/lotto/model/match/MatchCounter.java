package lotto.model.match;

import java.util.List;

public interface MatchCounter<T extends Number> {

    int countMatches(List<T> list, List<T> list2);
}
