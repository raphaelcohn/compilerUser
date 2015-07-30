/*
 * This file is part of compilerUser. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of compilerUser. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT.
 */

package com.compilerUser.pathExpressions;

import com.compilerUser.exceptions.FatalCompilationException;
import com.compilerUser.moduleName.ModuleName;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Path;

import static com.compilerUser.text.EnglishFormatter.format;
import static java.nio.file.Files.*;

public final class RootPathAndExpression
{
	@NotNull private final Path rootPath;
	@NotNull private final RelativePathExpression relativePathExpression;

	public RootPathAndExpression(@NotNull final Path rootPath, @NotNull final RelativePathExpression relativePathExpression)
	{
		this.rootPath = rootPath;
		this.relativePathExpression = relativePathExpression;
	}

	@NotNull
	public Path resolvePath(@NotNull final ModuleName moduleName) throws IllegalRelativePathException, FatalCompilationException
	{
		final Path relativePath = relativePathExpression.evaluateToPath(moduleName);
		final Path nearlyAbsolutePath = rootPath.resolve(relativePath);

		@NotNull final Path absolutePath;
		if (exists(nearlyAbsolutePath))
		{
			try
			{
				absolutePath = nearlyAbsolutePath.toRealPath();
			}
			catch (final IOException e)
			{
				throw new FatalCompilationException(format("Ignoring entire %4$s contents of module %1$s because could not resolve paths '%2$s', '%3$s' due to '%4$s'", moduleName, rootPath, relativePath, e.getMessage()), e);
			}
		}
		else
		{
			try
			{
				absolutePath = createDirectories(nearlyAbsolutePath).toRealPath();
			}
			catch (final IOException e)
			{
				throw new FatalCompilationException(format("Ignoring entire contents of module %1$s because resolved source path %2$s does not exist and could not be created or used due to '%3$s'", moduleName, nearlyAbsolutePath, e.getMessage()), e);
			}
		}

		if (!isDirectory(absolutePath))
		{
			throw new FatalCompilationException(format("Ignoring entire contents of module %1$s because resolved source path %2$s is not a directory", moduleName, nearlyAbsolutePath));
		}

		if (!isReadable(absolutePath))
		{
			throw new FatalCompilationException(format("Ignoring entire contents of module %1$s because resolved source path %2$s is not readable", moduleName, nearlyAbsolutePath));
		}

		return absolutePath;
	}
}
