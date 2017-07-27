package eu.scp.z1ckz4ck.archeryscores.contentProv;

import eu.scp.z1ckz4ck.archeryscores.entity.Target;
import eu.scp.z1ckz4ck.archeryscores.enums.ScoreType;

import java.util.ArrayList;
import java.util.List;

public class DbParcour {

    private int id;
    private String name;
    private int targetCount;
    private String lenght;
    private String timeToFinish;



    public DbParcour(int id, String name, int targetCount, String lenght, String timeToFinish) {
        this.id = id;
        this.name = name;
        this.targetCount = targetCount;
        this.lenght = lenght;
        this.timeToFinish = timeToFinish;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTargetCount() {
        return targetCount;
    }

    public void setTargetCount(int targetCount) {
        this.targetCount = targetCount;
    }

    public String getLenght() {
        return lenght;
    }

    public void setLenght(String lenght) {
        this.lenght = lenght;
    }

    public String getTimeToFinish() {
        return timeToFinish;
    }

    public void setTimeToFinish(String timeToFinish) {
        this.timeToFinish = timeToFinish;
    }

}
