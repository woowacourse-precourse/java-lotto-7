package global.io;

import java.util.List;

public interface InputHandler {
    // todo: min, max를 설정하도록
    Integer getIntegerInput(int limit);
    List<Integer> getIntegerListInput(int size);
}
