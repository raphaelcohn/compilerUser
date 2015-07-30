/*
 * This file is part of compilerUser. It is subject to the licence terms in the COPYRIGHT file found in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT. No part of compilerUser, including this file, may be copied, modified, propagated, or distributed except according to the terms contained in the COPYRIGHT file.
 * Copyright © 2014-2015 The developers of compilerUser. See the COPYRIGHT file in the top-level directory of this distribution and at https://raw.githubusercontent.com/raphaelcohn/compilerUser/master/COPYRIGHT.
 */

package com.compilerUser.elementHandlers;

import com.sun.source.util.TreePath;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.WildcardType;

public interface AbstractSyntaxTreeInterpreter
{
	@NotNull
	String getCanonicalClassName(@NotNull final TypeElement element);

	boolean isEqualRawTypeElement(@SuppressWarnings("TypeMayBeWeakened") @NotNull DeclaredType classInterfaceEnumOrAnnotation, @NotNull Class<?> clazz);

	@NotNull
	TypeElement typeElementFor(@NotNull Class<?> clazz);

	@NotNull
	WildcardType wildcardTypeSuper(@NotNull TypeMirror superBound);

	@NotNull
	WildcardType wildcardTypeExtends(@NotNull TypeMirror extendsBound);

	// null for PackageElement
	@Nullable
	TreePath treePathForElement(@NotNull Element element);
}
