/*
 * This file is part of compilerUser. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of compilerUser. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT.
 */

package com.compilerUser.text;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

import static java.util.Locale.ENGLISH;

@SuppressWarnings("UtilityClass")
public final class EnglishFormatter
{
	@NotNull
	public static final Locale FormatterLocale = ENGLISH;

	@NotNull
	@NonNls
	public static String format(@NotNull @NonNls final String format, @NotNull @NonNls final Object... args)
	{
		return String.format(FormatterLocale, format, args);
	}

	private EnglishFormatter()
	{
	}
}
