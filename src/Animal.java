import java.util.List;

/**
 * A class representing shared characteristics of animals.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (2)
 */
public abstract class Animal
{
    // Whether the animal is alive or not.
    private boolean alive;
    // The animal's field.
    private Field field;
    // The animal's position in the field.
    private Location location;

    // The age at which a fox can start to breed.
    private int breedingAge;
    // The age to which a fox can live.
    private int maxAge;
    // The likelihood of a fox breeding.
    private double breedingChance;
    // The maximum number of births.
    private int maxLitter;


    public Animal(Field field, Location location, int breedingAge, int maxAge, double breedingChance, int maxLitter) {
        this.alive = true;
        this.field = field;
        this.location = location;
        this.breedingAge = breedingAge;
        this.maxAge = maxAge;
        this.breedingChance = breedingChance;
        this.maxLitter = maxLitter;
    }

    public int getBreedingAge() {
        return breedingAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public double getBreedingChance() {
        return breedingChance;
    }

    public int getMaxLitter() {
        return maxLitter;
    }

    /**
     * Make this animal act - that is: make it do
     * whatever it wants/needs to do.
     * @param newAnimals A list to receive newly born animals.
     */
    abstract public void act(List<Animal> newAnimals);

    /**
     * Check whether the animal is alive or not.
     * @return true if the animal is still alive.
     */
    protected boolean isAlive()
    {
        return alive;
    }

    /**
     * Indicate that the animal is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * Return the animal's location.
     * @return The animal's location.
     */
    protected Location getLocation()
    {
        return location;
    }
    
    /**
     * Place the animal at the new location in the given field.
     * @param newLocation The animal's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    
    /**
     * Return the animal's field.
     * @return The animal's field.
     */
    protected Field getField()
    {
        return field;
    }
}
