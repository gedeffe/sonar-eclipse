/*
 * SonarQube Eclipse
 * Copyright (C) 2010-2015 SonarSource
 * sonarqube@googlegroups.com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.ide.eclipse.jdt.internal;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.JavaCore;
import org.sonar.ide.eclipse.core.AbstractPlugin;
import org.sonar.ide.eclipse.core.internal.SonarCorePlugin;

public class SonarJdtPlugin extends AbstractPlugin {

  public static final String PLUGIN_ID = "org.sonar.ide.eclipse.jdt"; //$NON-NLS-1$

  private static SonarJdtPlugin plugin;

  public SonarJdtPlugin() {
    plugin = this;
  }

  /**
   * @return the shared instance
   */
  public static SonarJdtPlugin getDefault() {
    return plugin;
  }

  public static boolean hasJavaNature(IProject project) {
    try {
      return project.hasNature(JavaCore.NATURE_ID);
    } catch (CoreException e) {
      SonarCorePlugin.getDefault().error(e.getMessage(), e);
      return false;
    }
  }

}
