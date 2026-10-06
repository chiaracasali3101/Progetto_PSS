package it.unibo.gridgames.view;

public enum UIConstants {
    MARGIN_TOP(30),
    MARGIN_BOTTOM(20),
    FONT_SIZE_TITLE(36),
    GRID_SIZE(10);

    private final int value;

    UIConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
