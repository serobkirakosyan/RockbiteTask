package org.example;

import java.util.Objects;

/**
 * An implementation of interface Material.
 * Stores information about Material.
 * @author Author: Serob Kirakosyan
 * @since Since: 17.04.2024
 */
public class MaterialType implements Material {

    private String name;
    private String icon;
    private String description;
    private int maxCap;

    public MaterialType(String name, String icon, String description, int maxCap) {
        this.name = name;
        this.icon = icon;
        this.description = description;
        this.maxCap = maxCap;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getIcon() {
        return icon;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public int getMaxCap() {
        return maxCap;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMaxCap(int maxCap) {
        this.maxCap = maxCap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaterialType that = (MaterialType) o;
        return maxCap == that.maxCap && Objects.equals(name, that.name) && Objects.equals(icon, that.icon) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, icon, description, maxCap);
    }
}
