package com.example.ibsys2.backend.Entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkplaceProductMerge {
    int workplaceId;
    int productId;
    int durationPerUnit;
    int setupTime;

    public int getWorkplaceId() {
        return workplaceId;
    }

    public int getProductId() {
        return productId;
    }

    public int getDurationPerUnit() {
        return durationPerUnit;
    }

    @JsonCreator
    public WorkplaceProductMerge(@JsonProperty("workplaceId") int workplaceId,
                                 @JsonProperty("productId") int productId,
                                 @JsonProperty("durationPerUnit") int durationPerUnit,
                                 @JsonProperty("setupTime") int setupTime) {
        this.workplaceId = workplaceId;
        this.productId = productId;
        this.durationPerUnit = durationPerUnit;
        this.setupTime = setupTime;
    }
}
