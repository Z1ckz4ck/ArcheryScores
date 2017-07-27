package eu.scp.z1ckz4ck.archeryscores.entity;

import eu.scp.z1ckz4ck.archeryscores.enums.TargetType;

import java.io.Serializable;

/**
 * Created by z1ckz4ck on 22.01.17.
 */
public class Target implements Serializable{

    private int targetId;
    private Integer nrTarget;
    private String nameTarget;
    private Integer distance;
    private TargetType targetType;
    private int parcourId;


    public Target(int nr) {
        nrTarget = nr;
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

    public int getParcourId() { return parcourId; }

    public void setParcourId(int parcourId) { this.parcourId = parcourId; }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }
}
