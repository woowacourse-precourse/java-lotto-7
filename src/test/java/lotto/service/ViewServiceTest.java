package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ViewServiceTest {

    ViewService viewService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void validateMoney() {
        assertThatThrownBy(() -> viewService.validateMoney(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateNumberSize() {
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6,7);
        assertThatThrownBy(()-> viewService.validateNumberSize(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}