/*
 * This file is part of compilerUser. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of compilerUser. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT.
 */

package com.compilerUser.pathExpressions;

import com.compilerUser.moduleName.ModuleName;
import org.jetbrains.annotations.NotNull;

import java.nio.file.InvalidPathException;

import static java.lang.String.format;
import static java.util.Locale.ENGLISH;

public final class IllegalRelativePathException extends Exception
{
	public IllegalRelativePathException(@NotNull final String path, @NotNull final ModuleName moduleName, @NotNull final String moduleRelativeSourcePathExpression)
	{
		super(format(ENGLISH, "Module Relative Source Path (%1$s) formed from moduleName (%2$s) and moduleRelativeSourcePathExpression (%3$s) is absolute", path, moduleRelativeSourcePathExpression, moduleName));
	}

	public IllegalRelativePathException(@NotNull final String path, @NotNull final ModuleName moduleName, @NotNull final String moduleRelativeSourcePathExpression, @NotNull final InvalidPathException cause)
	{
		super(format(ENGLISH, "Module Relative Source Path (%1$s) formed from moduleName (%2$s) and moduleRelativeSourcePathExpression (%3$s) is invalid", path, moduleRelativeSourcePathExpression, moduleName), cause);
	}
}
