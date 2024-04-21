package org.example;

/**
 * For testing the methods.
 * @author Author: Serob Kirakosyan.
 * @since Since: 17.04.2024.
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        Service service = new Service();
        Material material = new MaterialType("Iron", "Cat", "Black Iron", 20);

        Warehouse warehouse1 = service.addWarehouse(user , "warehouse1");
        Warehouse warehouse2 = service.addWarehouse(user, "warehouse2");
        service.addMaterial(user,"warehouse1", material, 25);
        service.removeMaterial(user,"warehouse1", material, 23);
        service.addMaterial(user,"warehouse1",material,15);
        service.moveMaterial(user ,"warehouse1", "warehouse2", material, 17);
        System.out.println(service.getAllMaterialCapacity(user, material));
        service.removeWarehouse(user,"warehouse1");
        service.removeWarehouse(user,"warehouse2");
    }

}