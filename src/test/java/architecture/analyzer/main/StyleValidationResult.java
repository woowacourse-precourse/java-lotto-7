package architecture.analyzer.main;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;

public record StyleValidationResult(List<CodeViolation> violations) {

    public void assertNoViolations() {
        assertThat(violations).isEmpty();
    }
}
