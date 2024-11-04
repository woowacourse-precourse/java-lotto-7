package lotto.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ViewControllerTest {
    ViewControllerImpl viewController;

    @BeforeEach
    void setUp() {
        viewController = ViewControllerImpl.getInstance();
    }

    @Test
    void validateMoney() {
        assertThatThrownBy(() -> viewController.validateMoney(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNumberSize() {
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6,7);
        assertThatThrownBy(()-> viewController.validateNumberSize(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}