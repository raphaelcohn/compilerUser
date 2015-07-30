/*
 * This file is part of compilerUser. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of compilerUser. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT.
 */

package com.compilerUser.elementHandlers;

import org.jetbrains.annotations.NotNull;

import javax.lang.model.element.Element;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

import static com.compilerUser.text.EnglishFormatter.format;

public final class RootElementHandler<A extends AbstractSyntaxTreeInterpreter> implements ElementHandler<Element, A>
{
	@NotNull
	private final ElementHandler<PackageElement, A> packageElementHandler;

	@NotNull
	private final ElementHandler<TypeElement, A> typeElementHandler;

	public RootElementHandler(@SuppressWarnings("TypeMayBeWeakened") @NotNull final ElementHandler<PackageElement, A> packageElementHandler, @SuppressWarnings("TypeMayBeWeakened") @NotNull final ElementHandler<TypeElement, A> typeElementHandler)
	{
		this.packageElementHandler = packageElementHandler;
		this.typeElementHandler = typeElementHandler;
	}

	@SuppressWarnings("ChainOfInstanceofChecks")
	@Override
	public void handle(@NotNull final A abstractSyntaxTreeInterpreter, @NotNull final Element element)
	{
		if (element instanceof TypeElement)
		{
			typeElementHandler.handle(abstractSyntaxTreeInterpreter, (TypeElement) element);
		}
		else if (element instanceof PackageElement)
		{
			packageElementHandler.handle(abstractSyntaxTreeInterpreter, (PackageElement) element);
		}
		else
		{
			throw new IllegalStateException(format("Did not expect a root element of class '%1$s'", element.getClass()));
		}
	}

}
