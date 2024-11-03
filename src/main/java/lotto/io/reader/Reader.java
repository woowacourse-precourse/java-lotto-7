package lotto.io.reader;

import java.util.List;

public interface Reader {

    List<Integer> readLineAsNumbers(String spliter);

    int readLineAsNumber();
}
