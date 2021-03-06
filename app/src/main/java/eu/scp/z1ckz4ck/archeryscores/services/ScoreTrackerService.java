package eu.scp.z1ckz4ck.archeryscores.services;

import android.app.Application;
import eu.scp.z1ckz4ck.archeryscores.contentProv.DbHandlerParcours;
import eu.scp.z1ckz4ck.archeryscores.contentProv.DbHandlerTarget;
import eu.scp.z1ckz4ck.archeryscores.contentProv.DbHandlerUser;
import eu.scp.z1ckz4ck.archeryscores.contentProv.DbParcour;
import eu.scp.z1ckz4ck.archeryscores.entity.Parcour;
import eu.scp.z1ckz4ck.archeryscores.entity.User;
import eu.scp.z1ckz4ck.archeryscores.enums.ScoreType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by z1ckz4ck on 11.03.17.
 */
public class ScoreTrackerService extends Application{
    private static final String TAG = "ScoreTrackerService";

    private DbHandlerUser dbHandlerUser;
    private List<User> activeUserL;
    private ScoreType scoreType;
    private DbHandlerParcours dbHandlerParcours;
    private DbHandlerTarget dbHanderTargets;

    public ScoreTrackerService() {
        dbHandlerUser = new DbHandlerUser(this);
        activeUserL = new ArrayList<>();
    }

    public synchronized void addUser(User user) {
        dbHandlerUser.addUser(user);
    }

    public synchronized List<User> refreshAndgetAllUser(){
        return dbHandlerUser.getAllUser();
    }

    public synchronized void deleteUser(User user){
        dbHandlerUser.deleteUser(user);
    };
    public synchronized void deleteUser(int userId){
        dbHandlerUser.deleteUser(userId);
    };

    public synchronized User getUser(int id){
        return dbHandlerUser.getUser(id);
    }

    public synchronized void saveOrUpdate(User user){
        if (user != null && user.geteMail() != null){
            if(user.getUserId() == -1){
                dbHandlerUser.addUser(user);
            }else{
                User userDb = dbHandlerUser.getUser(user.getUserId());
                userDb.setFirstName(user.getFirstName());
                userDb.setLastName(user.getLastName());
                userDb.seteMail(user.geteMail());
                dbHandlerUser.updateUser(userDb);
            }
        }
    }


    public ScoreType getScoreType() {
        return scoreType;
    }

    public void setScoreType(ScoreType scoreType) {
        this.scoreType = scoreType;
    }


    public synchronized void addParcour(Parcour parcour){
        DbParcour par = new DbParcour(parcour.getId(), parcour.getName(),parcour.getTargetCount(), parcour.getLenght(),parcour.getTimeToFinish());
        dbHandlerParcours.addParcour(par);

        dbHanderTargets.addAll(parcour.getListTargets());
    }

    public synchronized void deleteParcour(Parcour parcour){};
}
