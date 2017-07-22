package eu.scp.z1ckz4ck.archeryscores.entity;

import eu.scp.z1ckz4ck.archeryscores.enums.TargetType;

import java.io.Serializable;

/**
 * Created by z1ckz4ck on 22.01.17.
 */
public class Target implements Serializable{


    private Integer nrTarget;
    private String nameTarget;
    private Integer distance;
    private TargetType targetType;


    public Target(Integer nrTarget) {
        this.nrTarget =nrTarget;

    }

    /**++++++++++++++++++++++Getter & Setter++++++++++++++++++++++*/

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public TargetType getTargetType() {
        return targetType;
    }

    public void setTargetType(TargetType targetType) {
        this.targetType = targetType;
    }


    public String getNameTarget() {
        return nameTarget;
    }

    public void setNameTarget(String nameTarget) {
        this.nameTarget = nameTarget;
    }

    public Integer getNrTarget() {
        return nrTarget;
    }

    public void setNrTarget(Integer nrTarget) {
        this.nrTarget = nrTarget;
    }
}
