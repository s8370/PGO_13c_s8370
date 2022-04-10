package g13c.cw3.zad1;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class RailwayStation {
    private String name;
    private int platformsNumber = 3;
    private final LinkedList<Train> trains = new LinkedList<>();

    public RailwayStation(String name) {
        setName(name);
    }

    public RailwayStation(String name, int platformsNumber) {
        setName(name);
        setPlatformsNumber(platformsNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new RuntimeException("Nazwa nie może być pusta");
        }
        this.name = name;
    }

    public int getPlatformsNumber() {
        return platformsNumber;
    }

    public void setPlatformsNumber(int platformsNumber) {
        if(platformsNumber < 3) {
            throw new RuntimeException("Minimalna ilość to 3");
        }
        this.platformsNumber = platformsNumber;
    }

    public void IncreaseTracks(int intrack){
        setPlatformsNumber(getPlatformsNumber() + intrack);
    }

    public Train LaunchTrain(String name){
        if(trains.size() >= this.getPlatformsNumber()){
            throw new RuntimeException("Maksymalna ilość pociagów: "+this.getPlatformsNumber());
        }
        Train newtrain = new Train(name);
        this.trains.addLast(newtrain);
        return newtrain;
    }

    @Override
    public String toString() {
        return "RailwayStation{" +
                "name='" + name + '\'' +
                ", platformsNumber=" + platformsNumber +
                ", trains=" + trains +
                '}';
    }
}
