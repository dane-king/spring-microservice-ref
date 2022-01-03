
package com.daneking.stockquote.request;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "@id",
    "elapsedtime",
    "quotes",
    "error"
})
@Generated("jsonschema2pojo")
public class Response {

    @JsonProperty("@id")
    private String id;
    @JsonProperty("elapsedtime")
    private String elapsedtime;
    @JsonProperty("quotes")
    private Quotes quotes;
    @JsonProperty("error")
    private String error;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("@id")
    public String getId() {
        return id;
    }

    @JsonProperty("@id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("elapsedtime")
    public String getElapsedtime() {
        return elapsedtime;
    }

    @JsonProperty("elapsedtime")
    public void setElapsedtime(String elapsedtime) {
        this.elapsedtime = elapsedtime;
    }

    @JsonProperty("quotes")
    public Quotes getQuotes() {
        return quotes;
    }

    @JsonProperty("quotes")
    public void setQuotes(Quotes quotes) {
        this.quotes = quotes;
    }

    @JsonProperty("error")
    public String getError() {
        return error;
    }

    @JsonProperty("error")
    public void setError(String error) {
        this.error = error;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
