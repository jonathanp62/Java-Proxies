package net.jmp.java.proxies.moving;

/*
 * (#)MoveDemo.java 0.1.0   05/09/2025
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
import java.lang.reflect.Proxy;

import net.jmp.java.proxies.Demo;

import static net.jmp.util.logging.LoggerUtils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// The move demonstration class.
///
/// @version    0.1.0
/// @since      0.1.0
public class MoveDemo implements Demo {
    /// The logger.
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /// The default constructor.
    public MoveDemo() {
        super();
    }

    /// The demo method.
    @Override
    public void demo() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        /* Proxy just the interface */

        final Walker walker = this.createProxyForInterface(Walker.class);

        walker.move();
        walker.walkHome();
        walker.walkToWork();

        /* Proxy a class that implements an interface */

        final Walker youngJonathan = WalkerProxy.newInstance(new Jonathan());

        youngJonathan.move();
        youngJonathan.walkHome();
        youngJonathan.walkToWork();

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }

    /// The create proxy method. Only
    /// interfaces can be proxied.
    ///
    /// @param  <T>     The type
    /// @param  ifc     java.lang.Class<T>
    /// @return         T
    private <T extends Moveable> T createProxyForInterface(final Class<T> ifc) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(ifc));
        }

        final Object object = Proxy.newProxyInstance(
                ifc.getClassLoader(),
                new Class[] {ifc},
                new MoveableHandler()
        );

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(object));
        }

        return ifc.cast(object);
    }

    /// The moveable handler class.
    class MoveableHandler implements InvocationHandler {
        /// The default constructor.
        public MoveableHandler() {
            super();
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

            final Destination destination = method.getAnnotation(Destination.class);

            if (destination != null) {
                logger.info("Moving to {}", destination.value());
            }

            if ("move".equals(method.getName())) {
                logger.info("Just moving");
            }

            return result;
        }
    }
}
