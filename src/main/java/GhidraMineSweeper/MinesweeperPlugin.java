package GhidraMineSweeper;

/* ###
 * IP: GHIDRA
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import GhidraMineSweeper.game.MinesweeperProvider;
import docking.ActionContext;
import docking.action.DockingAction;
import docking.action.MenuData;
import ghidra.app.ExamplesPluginPackage;
import ghidra.app.plugin.PluginCategoryNames;
import ghidra.app.plugin.core.bookmark.BookmarkProvider;
import ghidra.framework.plugintool.*;
import ghidra.framework.plugintool.util.PluginStatus;
import ghidra.util.Msg;

/**
 * A very simple example plugin.  It creates an action that, when invoked, prints "Hello World" to
 * the console.
 */
//@formatter:off
@PluginInfo(
        status = PluginStatus.RELEASED,
        packageName = ExamplesPluginPackage.NAME,
        category = PluginCategoryNames.MISC,
        shortDescription = "Adds Minesweeper Game",
        description = "Helps to pass the time while waiting for the decompiler to finish"
)

public class MinesweeperPlugin extends Plugin{

    private final MinesweeperProvider provider;
    private DockingAction helloAction;

    /**
     * Plugin constructor - all plugins must have a constructor with this signature
     * @param tool the pluginTool that this plugin is added to.
     */
    public MinesweeperPlugin(PluginTool tool) {
        super(tool);

        provider = new MinesweeperProvider(tool, this);
        provider.addToTool();

        createActions();
    }

    private void createActions() {
        
    }

}
