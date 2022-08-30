package ArrangeManager;

import java.util.HashMap;
import java.util.Map;

public class ScenarioProvider {
	private Map<String, Object> scenarioContext;
	
	public ScenarioProvider() {
		scenarioContext = new HashMap<>();
	}
	
	public void setContext(String key, Object value) {
		scenarioContext.put(key, value);
	}
	
	public Object getContext(String key) {
		return scenarioContext.get(key);
	}
}
