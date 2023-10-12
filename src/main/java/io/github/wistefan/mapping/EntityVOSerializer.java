package io.github.wistefan.mapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.context.annotation.Bean;
import io.micronaut.core.serialize.exceptions.SerializationException;
import io.micronaut.core.type.Argument;
import io.micronaut.jackson.serialize.JacksonObjectSerializer;
import jakarta.inject.Singleton;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

@Singleton
@Bean
public class EntityVOSerializer extends JacksonObjectSerializer {

    private final EntityVOMapper entityVOMapper;

    /**
     * @param objectMapper   To read/write JSON
     * @param entityVOMapper entityVO mapper
     */
    public EntityVOSerializer(ObjectMapper objectMapper, EntityVOMapper entityVOMapper) {
        super(objectMapper);
        this.entityVOMapper = entityVOMapper;
    }

    @Override
    public <T> Optional<T> deserialize(byte[] bytes, Class<T> requiredType) throws SerializationException {
        try {
            return Optional.ofNullable(entityVOMapper.deserialize(bytes, requiredType));
        } catch (IOException e) {
            throw new SerializationException("Error deserializing object from JSON: " + e.getMessage(), e);
        }
    }

    @Override
    public <T> Optional<T> deserialize(InputStream inputStream, Class<T> requiredType) throws SerializationException {
        try {
            return Optional.ofNullable(entityVOMapper.deserialize(inputStream, requiredType));
        } catch (IOException e) {
            throw new SerializationException("Error deserializing object from JSON: " + e.getMessage(), e);
        }
    }
}
