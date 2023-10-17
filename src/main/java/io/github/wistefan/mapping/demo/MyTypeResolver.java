package io.github.wistefan.mapping.demo;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeDeserializer;
import com.fasterxml.jackson.databind.jsontype.impl.StdTypeResolverBuilder;
import com.fasterxml.jackson.databind.jsontype.impl.TypeNameIdResolver;
import io.github.wistefan.mapping.AdditionalPropertyDeserializer;

import java.util.Collection;

/**
 * Resolver for our additional properties, to be used for deserialization.
 * It can deduce Property, GeoProperty, Relationship, PropertyList, GeoPropertyList and RelationShipList.
 * There is no need for a custom serializer, since the serializer has a concrete object at hand and the type is already
 * model immanent.
 */
public class MyTypeResolver extends StdTypeResolverBuilder {

	@Override
	public TypeDeserializer buildTypeDeserializer(DeserializationConfig config, JavaType baseType, Collection<NamedType> subtypes) {
		return new AsPropertyTypeDeserializer(
				baseType,
				TypeNameIdResolver.construct(config, baseType, subtypes, false, true),
				"type",
				false,
				defineDefaultImpl(config, baseType),
				JsonTypeInfo.As.PROPERTY,
				true
		);
	}


}
