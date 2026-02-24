package org.sadovodBase;
import java.util.List;
import java.util.ArrayList;

public class Location {

    private List<Plant> plants = new ArrayList<>();
    private List<Animal> animals = new ArrayList<>();

    public List<Plant> getPlants() {
        return plants;

    }
    public List<Animal> getAnimals() {
        return animals;
    }
    public void addPlant(Plant plant) {
        plants.add(plant);
    }
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }
    public void removeAnimal(Animal animal) {
        animals.remove(animal);
    }
 }
