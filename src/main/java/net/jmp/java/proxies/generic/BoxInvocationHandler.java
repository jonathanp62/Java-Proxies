package net.jmp.java.proxies.generic;

/*
 * (#)BoxInvocationHandler.java 0.2.0   05/11/2025
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

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import static net.jmp.util.logging.LoggerUtils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// The box invocation handler.
///
/// @param  <T> The type of item in the box.
/// @version    0.2.0
/// @since      0.2.0
public class BoxInvocationHandler<T> implements InvocationHandler {
    /// The logger.
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /// The box object.
    private final Box<T> box;

    /// The constructor.
    ///
    /// @param  box net.jmp.java.proxies.generic.Box<T>
    public BoxInvocationHandler(final Box<T> box) {
        super();

        this.box = box;
    }

    /// The invoke method.
    ///
    /// @param  proxy   java.lang.Object
    /// @param  method  java.lang.reflect.Method
    /// @param  args    java.lang.Object[]
    /// @return         java.lang.Object
    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
        /* Including the proxy class in trace logging causes a stack overflow at runtime when trace logging is enabled. */

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(method, args));
        }

        if (this.logger.isDebugEnabled()) {
            this.logger.debug("Proxy: {}", proxy.getClass().getName());
            this.logger.debug("Handling method {}", method.getName());
        }

        final Object result = method.invoke(this.box, args);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(result));
        }

        return result;
    }
}
