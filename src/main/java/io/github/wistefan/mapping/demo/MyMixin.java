package io.github.wistefan.mapping.demo;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeResolver;

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE)
@JsonTypeResolver(MyTypeResolver.class)
public abstract class MyMixin {
}
