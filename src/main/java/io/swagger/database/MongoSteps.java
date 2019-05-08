package io.swagger.database;

import io.swagger.model.StepEntry;
import io.swagger.model.WeightEntry;
import org.springframework.data.mongodb.core.mapping.Document;
import org.threeten.bp.OffsetDateTime;

@Document(collection = "steps")
public class MongoSteps {

    private String user;
    private Integer steps;
    private OffsetDateTime timestamp;

    public MongoSteps() {
    }

    public MongoSteps(String user, Integer steps, OffsetDateTime timestamp) {
        this.user = user;
        this.steps = steps;
        this.timestamp = timestamp;
    }

    public MongoSteps(String user, StepEntry stepEntry) {
        this(user, stepEntry.getSteps(), stepEntry.getTimestamp());
    }

    public StepEntry getStepEntry() {
        StepEntry stepEntry = new StepEntry();
        stepEntry.setSteps(this.getSteps());
        stepEntry.setTimestamp(this.getTimestamp());
        return stepEntry;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Integer getSteps() {
        return steps;
    }

    public void setSteps(Integer steps) {
        this.steps = steps;
    }

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
