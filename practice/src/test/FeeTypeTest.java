package test;

import main.vo.EnumMapper;
import main.vo.EnumMapperValue;
import main.vo.FeeType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

class FeeTypeTest {
    @Test
    void getNoBeanCategories() {
        Arrays.stream(FeeType.values())
                .map(EnumMapperValue::new)
                .forEach(System.out::println);
    }

    @Test
    void getCategories() {
        EnumMapper enumMapper = new EnumMapper();
        List<String> list = new ArrayList<>();
        list.add("FeeType");
        enumMapper.put("FeeType", FeeType.class);
        Map<String, List<EnumMapperValue>> stringListMap = enumMapper.get(list);
        System.out.println(stringListMap);
    }

}