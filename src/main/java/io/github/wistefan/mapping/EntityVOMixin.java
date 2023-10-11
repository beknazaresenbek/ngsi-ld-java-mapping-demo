package io.github.wistefan.mapping;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.fiware.ngsi.model.GeoPropertyVO;

public class EntityVOMixin {
    @JsonIgnore private GeoPropertyVO location;
    @JsonIgnore private GeoPropertyVO observationSpace;
    @JsonIgnore private GeoPropertyVO operationSpace;
}
