/*
 * This file is part of compilerUser. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of compilerUser. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT.
 */

package com.compilerUser.elementHandlers.typeElementHandlers;

import com.compilerUser.elementHandlers.ElementHandler;
import com.compilerUser.elementHandlers.AbstractSyntaxTreeInterpreter;
import org.jetbrains.annotations.NotNull;

import javax.lang.model.element.TypeElement;

public interface TypeElementHandler<A extends AbstractSyntaxTreeInterpreter>
{
	void handle(@NotNull final A abstractSyntaxTreeInterpreter, @NotNull final TypeElement element, @NotNull final ElementHandler<TypeElement, A> dispatchingTypeElementHandler);
}
