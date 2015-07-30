/*
 * This file is part of compilerUser. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of compilerUser. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT.
 */

package com.compilerUser.javaSourceFiles;

import com.compilerUser.exceptions.FatalCompilationException;
import com.compilerUser.warnings.Warnings;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;

import static com.compilerUser.text.EnglishFormatter.format;
import static java.nio.file.Files.walkFileTree;

@SuppressWarnings("ClassNamePrefixedWithPackageName")
public final class JavaSourceFilesFinder
{
	@NotNull
	private final Warnings warnings;

	public JavaSourceFilesFinder(@NotNull final Warnings warnings)
	{
		this.warnings = warnings;
	}

	@NotNull
	public Iterable<File> find(@NotNull final Path sourcePath) throws FatalCompilationException
	{
		final Collection<File> javaSourceFiles = new ArrayList<>(16);

		try
		{
			walkFileTree(sourcePath, new StatefulJavaSourceFileVisitor(warnings, new JavaSourceFileUser()
			{
				@Override
				public void use(@NotNull final Path javaSourceFilePath)
				{
					javaSourceFiles.add(javaSourceFilePath.toFile());
				}
			}));
		}
		catch (final IOException e)
		{
			throw new FatalCompilationException(format("Ignoring entire contents of source path %1$s because of '%2$s'", sourcePath, e.getMessage()), e);
		}

		return javaSourceFiles;
	}
}
