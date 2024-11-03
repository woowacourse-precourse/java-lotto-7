package lotto.common.util;

import java.util.UUID;

public class IdHolder {

    private IdHolder() {
        throw new IllegalStateException("[ERROR] Utility class의 생성자를 호출할 수 없습니다.");
    }

    public static String generateID() {
        return UUID.randomUUID().toString();
    }
}
