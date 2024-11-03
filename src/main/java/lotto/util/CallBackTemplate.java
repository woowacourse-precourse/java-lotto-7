package lotto.util;

import lotto.viewHandler.api.Api;
import lotto.viewHandler.exception.MyException;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class CallBackTemplate {
    public <T> T retry(Supplier<T> callback, Consumer<MyException> exceptionHandler) {
        while (true) {
            try {
                return callback.get();
            } catch (MyException e) {
                exceptionHandler.accept(e);
            }
        }
    }

    public void handleApiResponse(Api<?> api, Class<?> expectedType, Consumer<Api> handler) {
        if (expectedType.isInstance(api.getData())) {
            handler.accept(api);
        }
    }
}
