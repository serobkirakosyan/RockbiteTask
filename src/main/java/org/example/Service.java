package org.example;

import java.util.NoSuchElementException;

/**
 * Provides API for working with the service.
 * @author Author: Serob Kirakosyan
 * @since Since: 17.04.2024
 */
public class Service {


    /**
     * Adds the indicated warehouse.
     * @param user of type User
     * @param warehouseName of type String
     * @return returns the added warehouse.
     */
    public Warehouse addWarehouse(User user, String warehouseName) {
        return user.addWarehouse(warehouseName);
    }

    /**
     * Removes the indicated warehouse.
     * @param user of type User
     * @param warehouseName of type String
     */
    public void removeWarehouse(User user, String warehouseName) {
        try {
            user.removeWarehouse(warehouseName);
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
    }

    /**
     * Adds an indicated number of specified material in the indicated user's indicated warehouse.
     * @param user of type User
     * @param warehouseName of type String
     * @param material of type Material
     * @param capacity of type int.
     * @return Returns the given material.
     */

    public Material addMaterial(User user,String warehouseName, Material material, int capacity) {
        return user.getWarehouse(warehouseName).addMaterial(material, capacity);

    }

    /**
     * Removes an indicated number of specified material in the indicated user's indicated warehouse.
     * @param user of type User.
     * @param warehouseName of type String.
     * @param material of type Material.
     * @param capacity of type int.
     * @return Returns true if removed.
     */
    public boolean removeMaterial(User user,String warehouseName, Material material, int capacity) {
        try {
            user.getWarehouse(warehouseName).removeMaterial(material, capacity);
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
        return true;
    }

    /**
     * Moves the specified number of indicated material from specified warehouse to another specified warehouse of the user.
     * @param user of type user.
     * @param warehouseFrom of type String.
     * @param warehouseTo of type String.
     * @param material of type Material.
     * @param capacity of type int.
     * @return Returns true if the material is successfully moved.
     */
    public boolean moveMaterial(User user,String warehouseFrom, String warehouseTo, Material material, int capacity) {
        int currentCapacity = user.getWarehouse(warehouseFrom).getMaterialCapacity(material);
        int freeSpace = material.getMaxCap() - user.getWarehouse(warehouseTo).getMaterialCapacity(material);
        int maxCapacityCanMove = Math.min(currentCapacity, freeSpace);
        if (maxCapacityCanMove < capacity) {
            try {
                user.getWarehouse(warehouseFrom).removeMaterial(material, maxCapacityCanMove);
            } catch (NoSuchElementException e) {
                System.out.println(e);
            }
            user.getWarehouse(warehouseTo).addMaterial(material, maxCapacityCanMove);
            System.out.println("Moved only " + maxCapacityCanMove + " items");
            return true;
        }
        try {
            user.getWarehouse(warehouseFrom).removeMaterial(material, capacity);
        } catch (NoSuchElementException e) {
            System.out.println(e);
        }
        user.getWarehouse(warehouseTo).addMaterial(material, capacity);
        System.out.println("Material moved successfully");
        return true;
    }

    /**
     * Gives the capacity of the specified material in all the warehouses the specified user owns.
     * Throws <code>RuntimeException</code> if the user is null.
     * @param user of type User
     * @param material of type Material
     * @return Returns the capacity of the specified material.
     * @throws RuntimeException
     */
    public int getAllMaterialCapacity(User user, Material material) throws RuntimeException{
        if (user == null) throw new RuntimeException("User can't be null");
        int count = 0;
        for (Warehouse warehouse : user.getWarehouseList().values()) {
            count += warehouse.getMaterialCapacity(material);
        }
        return count;
    }


}
