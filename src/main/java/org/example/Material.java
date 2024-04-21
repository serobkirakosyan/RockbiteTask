package org.example;

/**
 * Classes implement the interface to be considered a type of Material.
 * Combines methods that are common for the Material types.
 * @author Author: Serob Kirakosyan
 * @since Since: 17.04.2024
 */
public interface Material {

    String getName();

    String getIcon();

    String getDescription();

    int getMaxCap();
}
