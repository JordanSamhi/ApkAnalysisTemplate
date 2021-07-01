package lu.uni.apkanalysistemplate;

import java.util.Set;
import soot.Unit;
import soot.jimple.DefinitionStmt;
import soot.toolkits.graph.DirectedGraph;
import soot.toolkits.scalar.ForwardFlowAnalysis;

/**
 * Example of the Reaching Definition Analysis
 * @author Jordan Samhi
 *
 */
public class ReachingDefinitionAnalysis extends ForwardFlowAnalysis<Unit, Set<DefinitionStmt>> {

	public ReachingDefinitionAnalysis(DirectedGraph<Unit> graph) {
		super(graph);
		doAnalysis();
	}

	/**
	 * Generate the information that we have at
	 * the beginning of the analysis (BI)
	 */
	@Override
	protected Set<DefinitionStmt> newInitialFlow() {
		//TODO
	}

	/**
	 * Performs the data flow propagation
	 */
	@Override
	protected void flowThrough(Set<DefinitionStmt> in, Unit d, Set<DefinitionStmt> out) {
		//TODO
	}

	/**
	 * Define the meet operator for this analysis
	 */
	@Override
	protected void merge(Set<DefinitionStmt> in1, Set<DefinitionStmt> in2, Set<DefinitionStmt> out) {
		//TODO
	}

	/**
	 * Copy method for convenience
	 */
	@Override
	protected void copy(Set<DefinitionStmt> source, Set<DefinitionStmt> dest) {
		dest.addAll(source);
	}
}