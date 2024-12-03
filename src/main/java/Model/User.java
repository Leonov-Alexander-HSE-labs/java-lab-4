package Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    private int id;
    private String name;
    private String age;
    private String company;
    private String photoURL;

    @JsonCreator
    public User(
            @JsonProperty("id") int id,
            @JsonProperty("name") String name,
            @JsonProperty("age") String age,
            @JsonProperty("company") String company,
            @JsonProperty("photoURL") String photoURL
    ) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.company = company;
        this.photoURL = photoURL;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        builder.append("User {")
                .append("id: ").append(id).append(", ")
                .append("name: '").append(name).append("', ")
                .append("age: '").append(age).append("', ")
                .append("company: '").append(company).append("', ")
                .append("photoURL: '").append(photoURL).append("'")
                .append("}");

        return builder.toString();
    }
}