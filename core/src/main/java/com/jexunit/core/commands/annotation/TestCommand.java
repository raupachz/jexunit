package com.jexunit.core.commands.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jexunit.core.commands.annotation.TestCommand.TestCommands;

/**
 * Annotation for representing a method or a class as the implementation for a test-command. A static method or a class
 * annotated with {@code @TestCommand} will be run as the implementation of the command(s) set as value.
 * 
 * @author fabian
 * 
 */
@Repeatable(TestCommands.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface TestCommand {

	/**
	 * Get the name(s) of the command(s) the annotated method implements.
	 * 
	 * @return the name(s) of the command(s) the annotated method implements
	 */
	String[] value() default {};

	/**
	 * Fast fail the complete test group, if this command fails.
	 * 
	 * @return true, if the command will fast fail the complete test group, else false (default)
	 */
	boolean fastFail() default false;

	/**
	 * Annotation for representing a method as the implementation for multiple test-commands.
	 * 
	 * @author fabian
	 * 
	 */
	@Retention(RetentionPolicy.RUNTIME)
	@Target({ ElementType.METHOD, ElementType.TYPE })
	public static @interface TestCommands {

		/**
		 * Get the list of TestCommans.
		 * 
		 * @return the list of the commands the annotated method implements
		 */
		TestCommand[] value();
	}
}