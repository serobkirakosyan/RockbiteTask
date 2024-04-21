package org.example;

import java.util.*;

/**
 * Stores information about the user.
 * Stores the kinds of the stores the user has.
 * Creates warehouses and removes them.
 *
 * @author Author: Serob Kirakosyan.
 * @since Since: 17.04.2024.
 */
public class User {

    private final Map<String, Warehouse> warehouseList = new HashMap<>();

    /**
     * Adds warehouses.
     * @param name of type String
     * @return returns the created warehouse.
     */
    public Warehouse addWarehouse(String name) {
        warehouseList.put(name, new Warehouse());
        System.out.println("Warehouse added successfully");
        return warehouseList.get(name);
    }

    /**
     * Removes a warehouse.
     * May throw a <code>NoSuchElementException</code> if the warehouse is not found.
     * @param name of type String.
     * @return Returns true if deleted, and false if not deleted.
     * @throws NoSuchElementException
     */
    public boolean removeWarehouse(String name) throws NoSuchElementException {
        if (!warehouseList.containsKey(name)) {
            throw new NoSuchElementException("Warehouse not found ");
        }
        warehouseList.remove(name);
        System.out.println("Warehouse removed successfully");
        return true;
    }

    /**
     * Returns the list of user's warehouses
     * @return Map of the user's warehouses.
     */
    public Map<String, Warehouse> getWarehouseList() {
        return warehouseList;
    }

    /**
     * Returns a specific warehouse.
     * @param name of type String
     * @return the indicated warehouse.
     */
    public Warehouse getWarehouse(String name) {
        return warehouseList.get(name);
    }

}
