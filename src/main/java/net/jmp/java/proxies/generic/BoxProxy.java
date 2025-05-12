package net.jmp.java.proxies.generic;

/*
 * (#)BoxProxy.java 0.2.0   05/12/2025
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

import java.lang.reflect.Proxy;

/// The box proxy class.
///
/// @version    0.2.0
/// @since      0.2.0
public class BoxProxy {
    /// The default constructor.
    private BoxProxy() {
        super();
    }

    /// The new instance method.
    ///
    /// @param  <T> The type of item in the box.
    /// @param  box net.jmp.java.proxies.generic.Box
    /// @return     net.jmp.java.proxies.generic.Box
    public static <T> Box<T> newInstance(final Box<T> box) {
        final Object proxy = Proxy.newProxyInstance(
                box.getClass().getClassLoader(),
                new Class[] { Box.class },
                new BoxInvocationHandler<>(box));

        return (Box<T>) proxy;
    }
}
