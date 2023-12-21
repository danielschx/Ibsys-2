package com.example.ibsys2.backend.Entity;

import java.util.ArrayList;

public class Workplace {
    int id;
    int waitingDuration;
    int duration;
    // workplaceId, productId, durationPerUnit, setupTime für jedes Produkt, welches
    // an diesem Arbeitsplatz hergestellt wird
    ArrayList<WorkplaceProductMerge> durationsforeachProductWorkplace;
    public ArrayList<ProductionTimes> productionTimes;
    public ArrayList<SetupTimes> setupTimes;

    public Workplace(int id, int duration,
                     ArrayList<WorkplaceProductMerge> durationsforeachProductWorkplace) {
        this.id = id;
        this.waitingDuration = 0;
        this.duration = duration;
        // In diese Liste nur die WorkplaceProductMerge-Objekte einfügen, die für diesen
        // Arbeitsplatz gefertigt werden
        this.durationsforeachProductWorkplace = durationsforeachProductWorkplace;
        this.productionTimes = new ArrayList<ProductionTimes>();
        this.setupTimes = new ArrayList<SetupTimes>();
    }

    public int getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public ArrayList<WorkplaceProductMerge> getDurationsforeachProductWorkplace() {
        return durationsforeachProductWorkplace;
    }

    public ArrayList<ProductionTimes> getProductionTimes() {
        return productionTimes;
    }

    public void setProductionTimes(ArrayList<ProductionTimes> productionTimes) {
        this.productionTimes = productionTimes;
    }

    public ArrayList<SetupTimes> getSetupTimes() {
        return setupTimes;
    }

    public void setSetupTimes(ArrayList<SetupTimes> setupTimes) {
        this.setupTimes = setupTimes;
    }
}
