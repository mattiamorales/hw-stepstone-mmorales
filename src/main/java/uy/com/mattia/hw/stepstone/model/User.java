package uy.com.mattia.hw.stepstone.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * From HW text:
 * A) Write java classes capable of representing data from the JSON
 *
 *
 * Created partially using http://www.jsonschema2pojo.org, from the schema in
 * resource json/schema/schema.json, and edited manually.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CREDITS",
    "STATUS",
    "NAME",
    "ID"
})
public class User {

    @JsonProperty("CREDITS")
    private Integer credits = 0;
    @JsonProperty("STATUS")
    private String status = "";
    @JsonProperty("NAME")
    private String name = "";
    @JsonProperty("ID")
    private Integer id = 0;

    @JsonProperty("CREDITS")
    public Integer getCredits() {
        return credits;
    }

    @JsonProperty("CREDITS")
    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @JsonProperty("STATUS")
    public String getStatus() {
        return status;
    }

    @JsonProperty("STATUS")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("NAME")
    public String getName() {
        return name;
    }

    @JsonProperty("NAME")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("ID")
    public Integer getId() {
        return id;
    }

    @JsonProperty("ID")
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {

        String text = "User: \n";

        text += "\tCredits: " + getCredits() + "\n";
        text += "\tStatus: " + getStatus() + "\n";
        text += "\tName: " + getName() + "\n";
        text += "\tId: " + getId() + "\n";

        return text;
    }
}
