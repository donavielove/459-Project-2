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
        
        ArrayList<Integer> trueFollowees = new ArrayList<Integer>();
        
        for (int i = 0; i < followees.length; i++) {
            if (followees[i]) {
            trueFollowees.add(i);
            }
        } 
        this._followees = trueFollowees;
    }


    public void setPendingTransaction(Set<Transaction> pendingTransactions) {
            this._pendingTransactions = new HashSet<>();
            for (Transaction tx : pendingTransactions) {
            this._pendingTransactions.add(tx.id);
            }
        }

    public Set<Transaction> getProposals() {
        // IMPLEMENT THIS
        return this._pendingTransactions;
    }

    public void receiveCandidates(ArrayList<Integer[]> candidates) {
        // IMPLEMENT THIS
    }
}
