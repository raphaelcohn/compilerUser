/*
 * This file is part of compilerUser. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of compilerUser. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT.
 */

package com.compilerUser.processors;

import com.compilerUser.codeTreeUsers.CodeTreeUser;
import org.jetbrains.annotations.NotNull;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import java.util.Set;

public final class CodeTreeUserAdaptingProcessor extends AbstractProcessor
{
	@NotNull
	private final CodeTreeUser codeTreeUser;

	public CodeTreeUserAdaptingProcessor(@NotNull final CodeTreeUser codeTreeUser)
	{
		this.codeTreeUser = codeTreeUser;
	}

	@Override
	public boolean process(@NotNull final Set<? extends TypeElement> annotations, @NotNull final RoundEnvironment roundEnv)
	{
		assert messager != null;
		assert typeUtilities != null;
		assert elementUtilities != null;
		assert trees != null;

		codeTreeUser.process(messager, typeUtilities, elementUtilities, trees, roundEnv.getRootElements());

		return true;
	}
}
