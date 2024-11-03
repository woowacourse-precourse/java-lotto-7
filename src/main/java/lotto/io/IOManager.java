package lotto.io;

import java.util.List;

public interface IOManager extends AutoCloseable {
    String getUserMessage();

    Integer getUserNumber();

    List<Integer> getUserNumbers();

    void printMessage(String message);
}
