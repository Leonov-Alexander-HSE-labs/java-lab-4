package Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Company {
    private int id;
    private int employees;
    private String name;
    private String industry;
    private String website;

    @JsonCreator
    public Company(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("industry") String industry,
            @JsonProperty("employees") int employees,
            @JsonProperty("website") String website
    ) {
        this.id = id;
        this.name = name;
        this.industry = industry;
        this.employees = employees;
        this.website = website;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIndustry() {
        return industry;
    }

    public int getEmployees() {
        return employees;
    }

    public String getWebsite() {
        return website;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        builder.append("Company {")
                .append("id: ").append(id).append(", ")
                .append("name: '").append(name).append("', ")
                .append("industry: '").append(industry).append("', ")
                .append("employees: ").append(employees).append(", ")
                .append("website: '").append(website).append("'")
                .append("}");

        return builder.toString();
    }
}
