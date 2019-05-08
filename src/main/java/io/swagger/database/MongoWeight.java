package io.swagger.database;

import io.swagger.model.WeightEntry;

import org.springframework.data.mongodb.core.mapping.Document;
import org.threeten.bp.OffsetDateTime;

@Document(collection = "weight")
public class MongoWeight {

    private String user;
    private Float weight;
    private OffsetDateTime timestamp;

    public MongoWeight() {
    }

    public MongoWeight(String user, Float weight, OffsetDateTime timestamp) {
        this.user = user;
        this.weight = weight;
        this.timestamp = timestamp;
    }

    public MongoWeight(String user, WeightEntry weightEntry) {
        this(user, weightEntry.getWeight(), weightEntry.getTimestamp());
    }

    public WeightEntry getWeightEntry() {
        WeightEntry weightEntry = new WeightEntry();
        weightEntry.setWeight(this.getWeight());
        weightEntry.setTimestamp(this.getTimestamp());
        return weightEntry;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
