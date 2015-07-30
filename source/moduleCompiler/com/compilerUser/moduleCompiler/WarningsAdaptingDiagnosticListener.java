/*
 * This file is part of compilerUser. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of compilerUser. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT.
 */

package com.compilerUser.moduleCompiler;

import com.compilerUser.exceptions.FatalCompilationException;
import com.compilerUser.warnings.Warnings;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;

import java.net.URI;
import java.util.Locale;

import static com.compilerUser.text.EnglishFormatter.format;

public final class WarningsAdaptingDiagnosticListener implements DiagnosticListener<JavaFileObject>
{
	@NotNull
	private final Warnings warnings;

	public WarningsAdaptingDiagnosticListener(@NotNull final Warnings warnings)
	{
		this.warnings = warnings;
	}

	@NotNull
	public Locale locale()
	{
		return warnings.locale();
	}

	@Override
	public void report(@NotNull final Diagnostic<? extends JavaFileObject> diagnostic)
	{
		@Nullable final JavaFileObject source = diagnostic.getSource();
		@NonNls final String path;
		if (source == null)
		{
			path = "(none)";
		}
		else
		{
			final URI uri = source.toUri();
			path = uri.getPath();
		}

		final String message = format("'%1$s' in file %2$s at line %3$s column %4$s", diagnostic.getMessage(warnings.locale()), path, diagnostic.getLineNumber(), diagnostic.getColumnNumber());

		switch (diagnostic.getKind())
		{
			case ERROR:
				warnings.fatal(new FatalCompilationException(message));
				break;

			case WARNING:
				warnings.warn(message);
				break;

			case MANDATORY_WARNING:
				warnings.warn(message);
				break;

			case NOTE:
				warnings.information(message);
				break;

			case OTHER:
				warnings.information(message);
				break;
		}
	}
}
