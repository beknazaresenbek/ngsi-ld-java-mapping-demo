package io.github.wistefan.mapping.desc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.wistefan.mapping.demo.MyMixin;
import org.fiware.ngsi.model.AdditionalPropertyVO;
import org.fiware.ngsi.model.EntityVO;
import org.fiware.ngsi.model.GeoPropertyVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

public class DemoTest {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @BeforeEach
    public void setup() {
        OBJECT_MAPPER.addMixIn(AdditionalPropertyVO.class, MyMixin.class);
        OBJECT_MAPPER.findAndRegisterModules();
    }

    @Test
    public void testDemo() throws JsonProcessingException {
        EntityVO entityVO = new EntityVO();

        GeoPropertyVO location = new GeoPropertyVO();
        location.setUnitCode("A");
        location.setValue("Val");
        entityVO.setLocation(location);

        GeoPropertyVO addProp = new GeoPropertyVO();
        addProp.setValue("V2");
        addProp.setCreatedAt(Instant.now());

        entityVO.setAdditionalProperties("dd", addProp);

        String s1 = OBJECT_MAPPER.writeValueAsString(entityVO);

        System.out.println(s1);

        EntityVO d1 = OBJECT_MAPPER.readValue(s1, EntityVO.class);

        System.out.println(d1);
    }

}
