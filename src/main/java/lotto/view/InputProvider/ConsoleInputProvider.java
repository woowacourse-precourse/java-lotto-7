package lotto.view.InputProvider;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class ConsoleInputProvider implements InputProvider {
    @Override
    public String readLine() {
        try {
            return Console.readLine();
        } catch (NoSuchElementException error) {
            throw new NoSuchElementException("입력을 받는데 실패했습니다.");
        } catch (IllegalStateException error) {
            throw new IllegalStateException("입력을 받는데 실패했습니다.");
        }
    }

    @Override
    public void close() {
        Console.close();
    }
}
