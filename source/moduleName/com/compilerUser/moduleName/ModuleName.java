/*
 * This file is part of compilerUser. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of compilerUser. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT.
 */

package com.compilerUser.moduleName;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class ModuleName
{
	@NonNls
	@NotNull
	private final String moduleName;

	public ModuleName(@NotNull final String moduleName) throws IllegalModuleNameException
	{
		//noinspection HardcodedFileSeparator
		if (moduleName.contains("\0") || moduleName.contains("/"))
		{
			throw new IllegalModuleNameException(moduleName);
		}
		this.moduleName = moduleName;
	}

	@NotNull
	public String asString()
	{
		return moduleName;
	}

	@Override
	public boolean equals(@Nullable final Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null || getClass() != obj.getClass())
		{
			return false;
		}

		final ModuleName that = (ModuleName) obj;

		return moduleName.equals(that.moduleName);
	}

	@Override
	public int hashCode()
	{
		return moduleName.hashCode();
	}

	@Override
	@NotNull
	public String toString()
	{
		return moduleName;
	}
}
