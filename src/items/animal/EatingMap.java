package items.animal;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import lombok.Getter;

import java.util.Map;

@Getter
public class EatingMap {
    private Map<String, Map<String, Integer>> eatableIndexes;
}
