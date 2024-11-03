package lotto.handler.token;

import java.util.HashMap;
import lotto.handler.ErrorMessage;

public class HandlerToken {
    private final HashMap<TokenType, Object> contents;
    private boolean isExpired = false;

    public HandlerToken() {
        contents = new HashMap<>();
    }

    public void addContent(TokenType tokenType, Object content) {
        contents.put(tokenType, content);
    }

    public void removeContent(TokenType tokenType) {
        contents.remove(tokenType);
    }

    public <T> T getContent(TokenType tokenType, Class<T> contentType) {
        Object content = contents.get(tokenType);
        if (contentType.isInstance(content)) {
            return contentType.cast(content);
        }
        throw new ClassCastException(ErrorMessage.CASTING_ERROR.getErrorMessage());
    }

    public boolean hasInvalidInput() {
        return contents.containsKey(TokenType.INVALID_INPUT_ERROR);
    }

    public void checkEnd() {
        isExpired = true;
    }

    public boolean isExpired() {
        return isExpired;
    }

}
