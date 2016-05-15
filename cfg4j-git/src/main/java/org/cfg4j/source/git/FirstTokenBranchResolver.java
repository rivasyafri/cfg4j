/*
 * Copyright 2015-2016 Norbert Potocki (norbert.potocki@nort.pl)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cfg4j.source.git;

import org.cfg4j.source.context.environment.Environment;

/**
 * Adapter for {@link Environment} to provide git branch resolution through {@link BranchResolver} interface.
 * The adaptation process works as follows:
 * <ul>
 * <li>the environment name is split into tokens divided by "/"</li>
 * <li>first token is treated as a branch name</li>
 * <li>if the branch name is empty ("", or contains only whitespaces) then the "master" branch is used</li>
 * </ul>
 */
public class FirstTokenBranchResolver implements BranchResolver {

  @Override
  public String getBranchNameFor(Environment environment) {
    String[] tokens = environment.getName().split("/");

    String branchName = tokens[0].trim();
    if (branchName.isEmpty()) {
      branchName = "master";
    }

    return branchName;
  }
}
