package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * AnonymUserData
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-24T07:50:52.967Z[GMT]")
public class AnonymUserData   {
  @JsonProperty("height")
  private Integer height = null;

  @JsonProperty("stepgoal")
  private Integer stepgoal = null;

  @JsonProperty("latestSteps")
  private Integer latestSteps = null;

  @JsonProperty("weightGoal")
  private Float weightGoal = null;

  @JsonProperty("latestWeight")
  private Float latestWeight = null;

  public AnonymUserData height(Integer height) {
    this.height = height;
    return this;
  }

  /**
   * Get height
   * @return height
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Integer getHeight() {
    return height;
  }

  public void setHeight(Integer height) {
    this.height = height;
  }

  public AnonymUserData stepgoal(Integer stepgoal) {
    this.stepgoal = stepgoal;
    return this;
  }

  /**
   * Get stepgoal
   * @return stepgoal
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Integer getStepgoal() {
    return stepgoal;
  }

  public void setStepgoal(Integer stepgoal) {
    this.stepgoal = stepgoal;
  }

  public AnonymUserData latestSteps(Integer latestSteps) {
    this.latestSteps = latestSteps;
    return this;
  }

  /**
   * Get latestSteps
   * @return latestSteps
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Integer getLatestSteps() {
    return latestSteps;
  }

  public void setLatestSteps(Integer latestSteps) {
    this.latestSteps = latestSteps;
  }

  public AnonymUserData weightGoal(Float weightGoal) {
    this.weightGoal = weightGoal;
    return this;
  }

  /**
   * Get weightGoal
   * @return weightGoal
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Float getWeightGoal() {
    return weightGoal;
  }

  public void setWeightGoal(Float weightGoal) {
    this.weightGoal = weightGoal;
  }

  public AnonymUserData latestWeight(Float latestWeight) {
    this.latestWeight = latestWeight;
    return this;
  }

  /**
   * Get latestWeight
   * @return latestWeight
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  public Float getLatestWeight() {
    return latestWeight;
  }

  public void setLatestWeight(Float latestWeight) {
    this.latestWeight = latestWeight;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AnonymUserData anonymUserData = (AnonymUserData) o;
    return Objects.equals(this.height, anonymUserData.height) &&
        Objects.equals(this.stepgoal, anonymUserData.stepgoal) &&
        Objects.equals(this.latestSteps, anonymUserData.latestSteps) &&
        Objects.equals(this.weightGoal, anonymUserData.weightGoal) &&
        Objects.equals(this.latestWeight, anonymUserData.latestWeight);
  }

  @Override
  public int hashCode() {
    return Objects.hash(height, stepgoal, latestSteps, weightGoal, latestWeight);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AnonymUserData {\n");
    
    sb.append("    height: ").append(toIndentedString(height)).append("\n");
    sb.append("    stepgoal: ").append(toIndentedString(stepgoal)).append("\n");
    sb.append("    latestSteps: ").append(toIndentedString(latestSteps)).append("\n");
    sb.append("    weightGoal: ").append(toIndentedString(weightGoal)).append("\n");
    sb.append("    latestWeight: ").append(toIndentedString(latestWeight)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
