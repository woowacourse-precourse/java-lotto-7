package global.io;

import java.util.List;

public interface OutputHandler {
    void printMessage(String message);
    void printList(List<?> list);
}
