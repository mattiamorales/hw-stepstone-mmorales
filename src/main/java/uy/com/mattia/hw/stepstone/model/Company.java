package uy.com.mattia.hw.stepstone.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * From HW text:
 * A) Write java classes capable of representing data from the JSON
 *
 * Created partially using http://www.jsonschema2pojo.org, from the schema in
 * resource json/schema/schema.json, and edited manually.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CREDITS",
    "PARENT_ID",
    "STATUS",
    "NAME",
    "ID",
    "CHILDREN",
    "USERS"
})
@JsonIgnoreProperties(ignoreUnknown=true)
public class Company {

    @JsonProperty("CREDITS")
    private Integer credits = 0;
    @JsonProperty("PARENT_ID")
    private Integer parentId = null;
    @JsonProperty("STATUS")
    private String status = "";
    @JsonProperty("NAME")
    private String name = "";
    @JsonProperty("ID")
    private Integer id = 0;
    @JsonProperty("CHILDREN")
    private List<Company> children = new ArrayList<>();
    @JsonProperty("USERS")
    private List<User> users = new ArrayList<>();

    @JsonProperty("CREDITS")
    public Integer getCredits() {
        return credits;
    }

    @JsonProperty("CREDITS")
    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    @JsonProperty("PARENT_ID")
    public Integer getParentId() {
        return parentId;
    }

    @JsonProperty("PARENT_ID")
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
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

    @JsonProperty("CHILDREN")
    public List<Company> getChildren() {
        return children;
    }

    @JsonProperty("CHILDREN")
    public void setChildren(List<Company> children) {
        this.children = children;
    }

    @JsonProperty("USERS")
    public List<User> getUsers() {
        return users;
    }

    @JsonProperty("USERS")
    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {

        String text = "Company: \n";

        text += "\tCredits: " + getCredits() + "\n";
        text += "\tParentId: " + getParentId() + "\n";
        text += "\tStatus: " + getStatus() + "\n";
        text += "\tName: " + getName() + "\n";
        text += "\tId: " + getId() + "\n";

        text += "\tChildren: [\n";
        for (Company c: getChildren()) {
            text += "\t\t" + c.toString().replaceAll("\n", "\n\t\t") + "\n";
        }
        text += "\t]\n";

        text += "\tUsers: [\n";
        for (User u: getUsers()) {
            text += "\t\t" + u.toString().replaceAll("\n", "\n\t\t") + "\n";
        }
        text += "\t]\n";

        return text;
    }
}
