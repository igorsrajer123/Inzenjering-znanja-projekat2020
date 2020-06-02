package similarity;

import ucm.gaia.jcolibri.exception.NoApplicableSimilarityFunctionException;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.LocalSimilarityFunction;


public class NewTableSimilarity implements LocalSimilarityFunction{

	@Override
	public double compute(Object value1, Object value2) throws NoApplicableSimilarityFunctionException {
		
		
		return 0;
	}

	@Override
	public boolean isApplicable(Object value1, Object value2) {
		if (value1 instanceof String && value2 instanceof String)
			return true;
		return false;
	}

}
