package com.llchen.restful.hello;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Greeting {

    private final long id;
    private final String content;
}
