/*
 * This file is part of compilerUser. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of compilerUser. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT.
 */

package com.compilerUser.text;

import org.jetbrains.annotations.NotNull;

import java.nio.charset.Charset;

import static java.nio.charset.Charset.forName;

public final class CharsetHelper
{
	@NotNull public static final Charset Utf8 = forName("UTF-8");

	private CharsetHelper()
	{
	}
}
