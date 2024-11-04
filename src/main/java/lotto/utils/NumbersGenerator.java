package lotto.utils;

import java.util.List;

@FunctionalInterface
public interface NumbersGenerator {
    List<Integer> createNumbers();
}