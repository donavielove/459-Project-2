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
        
        this._p_graph = p_graph;
        this._p_malicious = p_malicious;
        this._p_txDistribution = p_txDistribution;
        this._numRounds = numRounds;

          /* (From TestComplaintNode)
      // p_graph: parameter for random graph: prob. that an edge will exist
      // p_malicious: prob. that a node will be set to be malicious
      // p_txDistribution: probability of assigning an initial transaction to each node
      // numRounds: number of simulation rounds your nodes will run for */

    }

    public void setFollowees(boolean[] followees) {
        this._followees = followees;
    }


    public void setPendingTransaction(Set<Transaction> pendingTransactions) {
            this._pendingTransactions = new HashSet<Transaction>(pendingTransactions);
        }

    public Set<Transaction> getProposals() {
        // Clear the old set, but hold the old values of runnung getProposals temporarily.
        HashSet<Transaction> old = new HashSet<Transaction>(_pendingTransactions);
        _pendingTransactions.clear();
        return old;
    }


	public void receiveCandidates(ArrayList<Integer[]> candidates) {
		// IMPLEMENT THIS
		for (Integer[] Candidate : candidates) {
			Transaction t = new Transaction(Candidate[0]);
			if (_pendingTransactions.contains(t))
				continue;
			else {
				_pendingTransactions.add(t);
			}
		}
	}
}
