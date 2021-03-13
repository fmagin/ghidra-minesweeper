package GhidraMineSweeper.game;

import GhidraMineSweeper.MinesweeperPlugin;
import docking.WindowPosition;
import ghidra.app.context.ProgramActionContext;
import ghidra.framework.plugintool.ComponentProviderAdapter;
import ghidra.framework.plugintool.PluginTool;
import resources.ResourceManager;

import javax.swing.*;

public class MinesweeperProvider extends ComponentProviderAdapter {
    private JPanel panel;
    final static ImageIcon NOTE_ICON = ResourceManager.loadImage("images/bomb16.png");

    public MinesweeperProvider(PluginTool tool, MinesweeperPlugin plugin) {
        super(tool, "Minesweeper", plugin.getName(), ProgramActionContext.class);

        setIcon(NOTE_ICON);
        addToToolbar();

        panel = new Board(this);

        setDefaultWindowPosition(WindowPosition.BOTTOM);

        setWindowMenuGroup("Decompile");
        setIntraGroupPosition(WindowPosition.BOTTOM);
    }
    @Override
    public JPanel getComponent() {
        return panel;
    }

    public void resetGame() {
        panel = new Board(this);
    }
}
