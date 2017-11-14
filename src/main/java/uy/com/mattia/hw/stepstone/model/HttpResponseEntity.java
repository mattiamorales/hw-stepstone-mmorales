package uy.com.mattia.hw.stepstone.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * From HW text:
 * A) Write java classes capable of representing data from the JSON
 *
 *
 * Created using http://www.jsonschema2pojo.org, from the schema in
 * resource json/schema/schema.json, and edited manually.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "DATA",
    "MESSAGE",
    "STATUS",
    "RESULT"
})
public class HttpResponseEntity {

    @JsonProperty("DATA")
    private List<Company> data = new ArrayList<>();
    @JsonProperty("MESSAGE")
    private String message = "";
    @JsonProperty("STATUS")
    private Integer status = 0;
    @JsonProperty("RESULT")
    private Boolean result = false;

    @JsonProperty("DATA")
    public List<Company> getData() {
        return data;
    }

    @JsonProperty("DATA")
    public void setData(List<Company> dATA) {
        this.data = dATA;
    }

    @JsonProperty("MESSAGE")
    public String getMessage() {
        return message;
    }

    @JsonProperty("MESSAGE")
    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty("STATUS")
    public Integer getStatus() {
        return status;
    }

    @JsonProperty("STATUS")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @JsonProperty("RESULT")
    public Boolean getResult() {
        return result;
    }

    @JsonProperty("RESULT")
    public void setResult(Boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {

        String text = "HttpResponseEntity: \n";

        text += "\tMessage: " + getMessage() + "\n";
        text += "\tStatus: " + getStatus() + "\n";
        text += "\tResult: " + getResult() + "\n";
        text += "\tData: [\n";

        for (Company c: getData()) {
            text += "\t\t" + c.toString().replaceAll("\n", "\n\t\t") + "\n";
        }

        text += "\t]\n";

        return text;

    }

}
