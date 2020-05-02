package me.suski;

import java.util.HashSet;
import java.util.Set;

public class SetChallenge {
    private static Set<HeavenlyBody> solarSystem = new HashSet<>();

    public static void main(String[] args) {

        HeavenlyBody star = new Star("Moon", 0);
        solarSystem.add(star);

        HeavenlyBody temp = new Planet("Mercury", 88);
        solarSystem.add(temp);
        star.addSatellite(temp);

        temp = new Planet("Venus", 225);
        solarSystem.add(temp);
        star.addSatellite(temp);

        temp = new Planet("Earth", 365);
        solarSystem.add(temp);
        star.addSatellite(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon);
        temp.addSatellite(star);
        temp.showSatellites();

        temp = new Planet("Mars", 687);
        solarSystem.add(temp);
        star.addSatellite(temp);


        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.add(temp);
        star.addSatellite(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.add(tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        temp = new Planet("Saturn", 10759);
        solarSystem.add(temp);
        star.addSatellite(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.add(temp);
        star.addSatellite(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.add(temp);
        star.addSatellite(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.add(temp);
        star.addSatellite(temp);

        for (HeavenlyBody body : solarSystem) {
            System.out.println(body);
        }

        System.out.println("====================");

        HeavenlyBody a = temp;
        HeavenlyBody b = temp;
        HeavenlyBody c = star;
        HeavenlyBody d = tempMoon;
        System.out.println(a.equals(b));
        System.out.println(b.equals(a));
        System.out.println(a.equals(c));
        System.out.println(c.equals(a));
    }
}
