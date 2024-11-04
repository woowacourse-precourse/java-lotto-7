package lotto.io.input;

import static org.junit.jupiter.api.Assertions.*;

import lotto.io.output.UserPromptService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserInputServiceTest {
    private UserInputService userInputService;
    private UserPromptService userPromptService;
    private InputConverter inputConverter;

    @BeforeEach
    void setUp() {
        UserPromptService userPromptService = new UserPromptService();
        InputConverter converter = new InputConverter();
        this.userInputService = new UserInputService(userPromptService, converter);
    }

    @Test
    void 구입금액을_입력받는다() {

    }

    @Test
    void createWinningNumber() {
    }

    @Test
    void createBonusNumber() {
    }
}