package main.vo;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EnumMapper {
    private Map<String, List<EnumMapperValue>> factory = new LinkedHashMap<>();
    public EnumMapper() {}

    public void put(String key, Class<? extends EnumMapperType> e) {
        factory.put(key,toEnumValues(e));
    }

    private List<EnumMapperValue> toEnumValues(Class<? extends EnumMapperType> e) {
        return Arrays.stream(e.getEnumConstants())
                .map(EnumMapperValue::new)
                .toList();
    }
    public List<EnumMapperValue> get(String key) {
        return factory.get(key);
    }

    public Map<String, List<EnumMapperValue>> get(List<String> keys){
        if(Objects.isNull(keys) || keys.isEmpty()) return new LinkedHashMap<>();
        return keys.stream().collect(Collectors.toMap(Function.identity(), key -> factory.get(key)));
    }
    public Map<String, List<EnumMapperValue>> getAll() {return factory;}

}
