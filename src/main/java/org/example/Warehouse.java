package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Stores a <code>Map</code> of materials.
 * @author Author: Serob Kirakosyan.
 * @since Since: 17.04.2024.
 */
public class Warehouse {

    private final Map<Material, Integer> materials = new HashMap<>();

    /**
     * Adds materials in the warehouse.
     *
     * @param material of type Material.
     * @param capacity of type int.
     * @return the given material.
     */
    public Material addMaterial(Material material, int capacity) {
        int currentCapacity = getMaterialCapacity(material);
        if (capacity + currentCapacity < material.getMaxCap()) {
            materials.put(material, capacity + currentCapacity);
            System.out.println("Material added successfully");
            return material;
        }
        materials.put(material, material.getMaxCap());
        System.out.println("Added only " + (material.getMaxCap() - currentCapacity) + " items");
        return material;
    }

    /**
     * Removes the given material from the warehouse.
     * Throws <code>NoSuchElementException</code> if the given element is not found.
     *
     * @param material of type Material.
     * @param capacity of type int.
     * @return true if deleted
     * @throws NoSuchElementException
     */
    public boolean removeMaterial(Material material, int capacity) throws NoSuchElementException {
        if (!materials.containsKey(material)) {
            throw new NoSuchElementException("Material not found");
        }
        int currentCapacity = getMaterialCapacity(material);
        if (capacity <= currentCapacity) {
            materials.put(material, currentCapacity - capacity);
            System.out.println("Material removed successfully");
            return true;
        }
        materials.put(material, 0);
        System.out.println("Removed only " + currentCapacity + " items");
        return true;
    }

    /**
     * Returns the number of the specified material in the warehouse.
     *
     * @param material of type Material
     * @return the capacity of the indicated material.
     */
    public int getMaterialCapacity(Material material) {

        return materials.getOrDefault(material, 0);
    }


}
