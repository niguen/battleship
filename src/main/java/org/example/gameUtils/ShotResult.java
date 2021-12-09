package org.example.gameUtils;

/**
 * Enum that is used to communicate the result of an attack between the field and the player
 * HIT: A ship is hit
 * MISS: Nothing was hit
 * SUNK: A ship has been hit and sunk
 */
public enum ShotResult {
    HIT,
    MISS,
    SUNK
}
