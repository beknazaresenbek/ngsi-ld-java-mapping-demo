package io.github.wistefan.mapping;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer;

public class AdditionalPropertyObjectDeserializer extends AsPropertyTypeDeserializer {

    public AdditionalPropertyObjectDeserializer(JavaType bt, TypeIdResolver idRes, String typePropertyName,
                                                boolean typeIdVisible, JavaType defaultImpl,
                                                JsonTypeInfo.As inclusion, boolean strictTypeIdHandling) {
        super(bt, idRes, typePropertyName, typeIdVisible, defaultImpl, inclusion, strictTypeIdHandling);
    }
}
