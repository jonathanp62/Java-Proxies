package net.jmp.java.proxies.def;

/*
 * (#)MessageProxy.java 0.3.0   05/12/2025
 *
 * @author   Jonathan Parker
 *
 * MIT License
 *
 * Copyright (c) 2025 Jonathan M. Parker
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

import java.lang.reflect.*;

/// The message proxy class.
///
/// @version    0.3.0
/// @since      0.3.0
public class MessageProxy implements InvocationHandler {
    /// The object to be proxied.
    private final Message object;

    /// The constructor.
    ///
    /// @param  message net.jmp.java.proxies.def.Message
    public MessageProxy(final Message message) {
        super();

        this.object = message;
    }

    /// The new instance method.
    ///
    /// @param  message net.jmp.java.proxies.def.Message
    /// @return         net.jmp.java.proxies.def.Message
    public static Message newInstance(final Message message) {
        final Object proxy = Proxy.newProxyInstance(
                message.getClass().getClassLoader(),
                new Class[] { Message.class },
                new MessageProxy(message));

        return (Message) proxy;
    }

    /// The invoke method.
    ///
    /// @param  proxy   java.lang.Object
    /// @param  method  java.lang.reflect.Method
    /// @param  args    java.lang.Object[]
    /// @return         java.lang.Object
    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        if (method.isDefault()) {
            final Class<?> declaringClass = method.getDeclaringClass();

            /*
             * Returns a lookup object on a target class to emulate all
             * supported bytecode behaviors, including private access.
             */

            final MethodHandles.Lookup lookup =
                    MethodHandles.privateLookupIn(declaringClass, MethodHandles.lookup());

            /* Finds or creates an instance of the given method type. */

            final MethodType methodType =
                    MethodType.methodType(method.getReturnType(), method.getParameterTypes());

            MethodHandle handle = null;

            if (Modifier.isStatic(method.getModifiers())) {
                /* Produces a method handle for a static method. */

                handle = lookup.findStatic(declaringClass, method.getName(), methodType);
            } else {
                /* Produces an early-bound method handle for a virtual method. */

                handle = lookup.findSpecial(declaringClass, method.getName(), methodType, declaringClass);
            }

            return handle.bindTo(proxy).invokeWithArguments(args);
        }

        return method.invoke(this.object, args);
    }
}
