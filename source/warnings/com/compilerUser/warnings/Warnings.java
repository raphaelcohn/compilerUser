/*
 * This file is part of compilerUser. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of compilerUser. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT.
 */

package com.compilerUser.warnings;

import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;
import java.util.Locale;

@SuppressWarnings("ClassNamePrefixedWithPackageName")
public interface Warnings
{
	void fatal(@NotNull final Exception cause);

	void warn(@NotNull @NonNls final String warning);

	void information(@NotNull @NonNls final String information);

	@NotNull
	Locale locale();
}
