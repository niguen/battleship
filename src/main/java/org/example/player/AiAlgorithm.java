package org.example.player;

import org.example.gameUtils.Coordinate;

/**
 * Interface that gives the structure for implementation
 * of algorithms that can be used by the AiPlayer.
 */
public interface AiAlgorithm {

    /**
     * Returns the next Coordinate to shoot at.
     * @return
     */
    Coordinate getCoordinate();

    /**
     * Gives the algorithm the opportunity to react on a HIT result of a shot.
     */
    default void hitNotifier() {}
}
