package lotto.provider;

import java.util.List;

@FunctionalInterface
public interface NumbersProvider {

    List<Integer> getNumbers();

}
