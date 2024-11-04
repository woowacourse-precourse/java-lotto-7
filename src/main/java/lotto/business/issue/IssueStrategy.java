package lotto.business.issue;

import java.util.List;
import lotto.lotto.Lotto;

/**
 * <code>IssueStrategy</code> is an interface that provides the strategy to issue the <code>Lotto</code>.
 *
 * @see lotto.lotto.Lotto
 */
public interface IssueStrategy {
    /**
     * Issue the <code>Lotto</code>.
     *
     * @return the issued <code>Lotto</code>
     */
    Lotto issue();

    /**
     * Issue many <code>Lotto</code>s.
     *
     * @param numOfLotto the number of <code>Lotto</code>s to issue
     * @return the issued <code>Lotto</code>s
     * @throws UnsupportedOperationException if the method is not implemented
     */
    default List<Lotto> issueMany(int numOfLotto) {
        throw new UnsupportedOperationException("issueMany method is not implemented");
    }
}
