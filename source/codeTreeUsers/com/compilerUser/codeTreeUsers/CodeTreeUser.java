/*
 * This file is part of compilerUser. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of compilerUser. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT.
 */

package com.compilerUser.codeTreeUsers;

import com.sun.source.util.Trees;
import org.jetbrains.annotations.NotNull;

import javax.annotation.processing.Messager;
import javax.lang.model.element.Element;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import java.util.Set;

public interface CodeTreeUser
{
	void process(@NotNull final Messager messager, @NotNull final Types typeUtilities, @NotNull final Elements elementUtilities, @NotNull final Trees trees, @NotNull final Set<? extends Element> rootElements);
}
