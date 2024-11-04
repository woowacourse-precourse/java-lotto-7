package lotto.service;

import java.util.List;

@FunctionalInterface
public interface NumbersCreator {

    List<Integer> create();

}
