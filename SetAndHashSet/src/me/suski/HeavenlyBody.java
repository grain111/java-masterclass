package me.suski;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {

    private final String name;
    private final double orbitalPeriod;
    private final BodyTypes type;
    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes {
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes type) {
        this.type = type;
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(satellites);
    }

    public void showSatellites() {
        for (HeavenlyBody s : satellites) {
            System.out.println(s.getName());
        }
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public BodyTypes getType() {
        return type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        String objName = ((HeavenlyBody) obj).getName();
        BodyTypes objType = ((HeavenlyBody) obj).getType();
        return this.name.equals(objName) && this.type.equals(objType);
    }

    @Override
    public int hashCode() {
        System.out.println("hashcode called");
        return this.name.hashCode() + this.type.hashCode() + 57;
    }


    @Override
    public String toString() {
        return "HeavenlyBody{" +
                "name='" + name + '\'' +
                ", orbitalPeriod=" + orbitalPeriod +
                ", type=" + type +
                '}';
    }
}
