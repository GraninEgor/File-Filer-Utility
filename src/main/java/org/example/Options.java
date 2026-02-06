package org.example;

public class Options {
    private final String path;
    private final String prefix;
    private final boolean inCurrentFilesMode;
    private final boolean fullStatisticsMode;

    public Options(String path, String prefix, boolean inCurrentFilesMode, boolean fullStatisticsMode) {
        this.path = path;
        this.prefix = prefix;
        this.inCurrentFilesMode = inCurrentFilesMode;
        this.fullStatisticsMode = fullStatisticsMode;
    }

    public String getPath() {
        return path;
    }

    public String getPrefix() {
        return prefix;
    }

    public boolean isInCurrentFilesMode() {
        return inCurrentFilesMode;
    }

    public boolean isFullStatisticsMode() {
        return fullStatisticsMode;
    }
}
