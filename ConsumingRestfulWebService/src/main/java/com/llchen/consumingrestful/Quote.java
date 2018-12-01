package com.llchen.consumingrestful;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Fetch a REST resource
 *
 * Spring provides a convenient template class called RestTemplate.
 * It makes interacting with most RESTful services a one-line incantation.
 *
 * This class is to contain the data we need
 *
 * In order for you to directly bind your data to your custom types, you need to specify
 * the variable name exact same as the key in the JSON Document returned from the API.
 * In case your variable name and key in JSON doc are not matching, you need to use
 * @JsonProperty annotation to specify the exact key of JSON document.
 */
@Data
// indicate that any properties not bound in this type should be ignored
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    private String type;
    private Value value;

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
