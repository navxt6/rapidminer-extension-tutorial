/**
 * RapidMiner
 *
 * Copyright (C) 2001-2014 by RapidMiner and the contributors
 *
 * Complete list of developers available at our web site:
 *
 * https://rapidminer.com
 *
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU Affero General Public License as published by the Free Software Foundation, either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License along with this program.
 * If not, see http://www.gnu.org/licenses/.
 */

package com.rapidminer;

import java.awt.event.ActionEvent;

import javax.swing.JMenu;

import com.rapidminer.gui.MainFrame;
import com.rapidminer.gui.tools.ResourceAction;
import com.rapidminer.gui.tools.ResourceMenu;


/**
 * This class provides hooks for initialization
 *
 * @author Sebastian Land
 */
public final class PluginInitTutorial {

	private PluginInitTutorial() {
		// Utility class constructor
	}

	/**
	 * This method will be called directly after the extension is initialized. This is the first
	 * hook during start up. No initialization of the operators or renderers has taken place when
	 * this is called.
	 */
	public static void initPlugin() {}

	/**
	 * This method is called during start up as the second hook. It is called before the gui of the
	 * mainframe is created. The Mainframe is given to adapt the gui. The operators and renderers
	 * have been registered in the meanwhile.
	 *
	 * @param mainframe
	 *            the RapidMiner Studio {@link MainFrame}.
	 */
	public static void initGui(MainFrame mainframe) {
		final SimpleWindow simpleWindow = new SimpleWindow();
		mainframe.getDockingDesktop().registerDockable(simpleWindow);

		JMenu menu = new ResourceMenu("tutorial.tutorial");
		menu.add(new ResourceAction("tutorial.greetings", "Earthling") {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				simpleWindow.setLabel("Greetings, Earthling");
			}

		});

		mainframe.getMainMenuBar().add(menu);
	}

	/**
	 * The last hook before the splash screen is closed. Third in the row.
	 */
	public static void initFinalChecks() {}

	/**
	 * Will be called as fourth method, directly before the UpdateManager is used for checking
	 * updates. Location for exchanging the UpdateManager. The name of this method unfortunately is
	 * a result of a historical typo, so it's a little bit misleading.
	 */
	public static void initPluginManager() {}
}
