package it.unibo.gridgames.view;

/** 
 * UIConstants defines constants used for UI layout and styling.
 */

public enum UIConstants {
    MARGIN_TOP(30),
    MARGIN_BOTTOM(20),
    FONT_SIZE_TITLE(36),
    GRID_SIZE(10),
    BUTTON_BACK(15),
    EXPECTED_FIELDS_COUNT(6),
    SCORE_20(20),
    SCORE_100(100),
    SCORE_200(200),
    SCORE_300(300),
    RECORDS_LIMIT(1),

    MOVES_0(0),
    MOVES_10(10),
    MOVES_20(20),

    TIMESTAMP_INDEX(5);

    private final int value;

    UIConstants(final int value) {
        this.value = value;
    }

    /**
     * Returns the integer value associated with the UI constant.
     * 
     * @return value 
     */
    public int getValue() {
        return value;
    }
}
