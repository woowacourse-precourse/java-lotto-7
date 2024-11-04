package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGeneratorTest {

    @BeforeEach
    void setUp() {
        // Clear any previously generated tickets
        LottoGenerator.getGeneratedTickets().clear();
    }

    @Test
    void generateAndStoreTickets_ShouldGenerateRequestedNumberOfTickets() {
        // When
        LottoGenerator.generateAndStoreTickets(3);

        // Then
        assertThat(LottoGenerator.getGeneratedTickets()).hasSize(3);
    }

    @Test
    void generateAndStoreTickets_ShouldGenerateTicketsWithCorrectSize() {
        // When
        LottoGenerator.generateAndStoreTickets(1);

        // Then
        List<Integer> ticket = LottoGenerator.getGeneratedTickets().get(0);
        assertThat(ticket).hasSize(LottoNumber.NUMBERS_SIZE);
    }

    @Test
    void generateAndStoreTickets_ShouldGenerateTicketsWithinValidRange() {
        // When
        LottoGenerator.generateAndStoreTickets(5);

        // Then
        for (List<Integer> ticket : LottoGenerator.getGeneratedTickets()) {
            for (int number : ticket) {
                assertThat(number)
                        .isGreaterThanOrEqualTo(LottoNumber.MIN_NUMBER)
                        .isLessThanOrEqualTo(LottoNumber.MAX_NUMBER);
            }
        }
    }

    @Test
    void generateAndStoreTickets_ShouldGenerateTicketsWithUniqueNumbers() {
        // When
        LottoGenerator.generateAndStoreTickets(3);

        // Then
        for (List<Integer> ticket : LottoGenerator.getGeneratedTickets()) {
            assertThat(ticket).doesNotHaveDuplicates();
        }
    }

    @Test
    void generateAndStoreTickets_ShouldGenerateSortedTickets() {
        // When
        LottoGenerator.generateAndStoreTickets(2);

        // Then
        for (List<Integer> ticket : LottoGenerator.getGeneratedTickets()) {
            assertThat(ticket).isSorted();
        }
    }

    @Test
    void getGeneratedTickets_ShouldReturnEmptyListWhenNoTicketsGenerated() {
        // When
        List<List<Integer>> tickets = LottoGenerator.getGeneratedTickets();

        // Then
        assertThat(tickets).isEmpty();
    }

    @Test
    void generateAndStoreTickets_ShouldAccumulateTickets() {
        // When
        LottoGenerator.generateAndStoreTickets(2);
        LottoGenerator.generateAndStoreTickets(3);

        // Then
        assertThat(LottoGenerator.getGeneratedTickets()).hasSize(5);
    }
}