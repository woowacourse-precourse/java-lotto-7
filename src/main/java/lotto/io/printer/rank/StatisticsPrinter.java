package lotto.io.printer.rank;

import java.util.Map;
import lotto.value.Rank;

public interface StatisticsPrinter {

    void printRankStatistics(Map<Rank, Integer> rankList);
}
