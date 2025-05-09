package net.jmp.java.proxies.moving;

/*
 * (#)WalkerProxy.java  0.1.0   05/09/2025
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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static net.jmp.util.logging.LoggerUtils.entry;
import static net.jmp.util.logging.LoggerUtils.exit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// The walker proxy class.
///
/// @version    0.1.0
/// @since      0.1.0
public class WalkerProxy implements InvocationHandler {
    /// The logger.
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /// The walker instance.
    private final Walker walker;

    /// The new instance method.
    ///
    /// @param walker   net.jmp.java.proxies.moving.Walker
    /// @return         java.lang.Object
    public static Object newInstance(final Walker walker) {
        return Proxy.newProxyInstance(
                walker.getClass().getClassLoader(),
                walker.getClass().getInterfaces(),
                new WalkerProxy(walker));
    }

    /// The constructor.
    ///
    /// @param walker  net.jmp.java.proxies.moving.Walker
    private WalkerProxy(final Walker walker) {
        this.walker = walker;
    }

    /// The invoke method.
    ///
    /// @param  proxy   java.lang.Object
    /// @param  method  java.lang.reflect.Method
    /// @param  args    java.lang.Object[]
    /// @return         java.lang.Object
    @Override
    public Object invoke(final Object proxy, final Method method, final Object[] args) {
        Object result = null;

        try {
            this.logger.debug("Before method: {}", method.getName());

            result = method.invoke(walker, args);
        } catch (final Exception e) {
            this.logger.error("Unexpected invocation exception", e);
        } finally {
            this.logger.debug("After method: {} ", method.getName());
        }

        return result;
    }
}
