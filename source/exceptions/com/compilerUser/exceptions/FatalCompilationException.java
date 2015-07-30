/*
 * This file is part of compilerUser. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of compilerUser. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT.
 */

package com.compilerUser.exceptions;

import org.jetbrains.annotations.NotNull;

public final class FatalCompilationException extends Exception
{
	public FatalCompilationException(@NotNull final String message)
	{
		super(message);
	}

	public FatalCompilationException(@NotNull final String message, @NotNull final Exception cause)
	{
		super(message, cause);
	}
}
