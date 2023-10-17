package io.github.wistefan.mapping.demo;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.AsArrayTypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import io.github.wistefan.mapping.AdditionalPropertyTypeResolver;
import io.github.wistefan.mapping.MappingException;
import org.fiware.ngsi.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyDeserializer extends AsPropertyTypeDeserializer {

	public MyDeserializer(JavaType bt, TypeIdResolver idRes, String typePropertyName, boolean typeIdVisible, JavaType defaultImpl, JsonTypeInfo.As inclusion, boolean strictTypeIdHandling) {
		super(bt, idRes, typePropertyName, typeIdVisible, defaultImpl, inclusion, strictTypeIdHandling);
	}
}
