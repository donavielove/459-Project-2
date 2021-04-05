import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* CompliantNode refers to a node that follows the rules (not malicious)*/
public class CompliantNode implements Node {
    // Defining variables
    public double _p_graph, _p_malicious, _p_txDistribution;
    public int _numRounds;
    public boolean[] _followees, blackListed;
    public Set<Transaction> _pendingTransactions = new HashSet<>();

    public CompliantNode(double p_graph, double p_malicious, double p_txDistribution, int numRounds) {
        // IMPLEMENT THIS
        this._p_graph = p_graph;
        this._p_malicious = p_malicious;
        this._p_txDistribution = p_txDistribution;
        this._numRounds = numRounds;
    }

    public void setFollowees(boolean[] followees) {
        // IMPLEMENT THIS
        this._followees = followees;
        this.blackListed = new boolean[followees.length];
    }

    public void setPendingTransaction(Set<Transaction> pendingTransactions) {
        // IMPLEMENT THIS
        this._pendingTransactions = pendingTransactions;
    }

    public Set<Transaction> getProposals() {
        // IMPLEMENT THIS
        return this._pendingTransactions;
    }

    public void receiveCandidates(ArrayList<Integer[]> candidates) {
        // IMPLEMENT THIS
    }
}
