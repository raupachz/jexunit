package com.jexunit.core.commands;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for representing a method as the implementation for a test-command. A static method
 * annotated with {@code @TestCommand} will be run as the implementation of the command(s) set as
 * value.
 * 
 * TODO: add possibility to define a class as testcommand
 * 
 * @author fabian
 * 
 */
@Repeatable(TestCommands.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD })
public @interface TestCommand {

	/**
	 * Get the name(s) of the command(s) the annotated method implements.
	 * 
	 * @return the name(s) of the command(s) the annotated method implements
	 */
	String[] value();
}