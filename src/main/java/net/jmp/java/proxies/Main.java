package net.jmp.java.proxies;

/*
 * (#)Main.java 0.3.0   05/12/2025
 * (#)Main.java 0.2.0   05/10/2025
 * (#)Main.java 0.1.0   05/08/2025
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

import java.util.List;

import net.jmp.java.proxies.def.DefaultDemo;
import net.jmp.java.proxies.generic.GenericDemo;
import net.jmp.java.proxies.moving.MoveDemo;
import net.jmp.java.proxies.pattern.PatternDemo;
import net.jmp.java.proxies.stat.StaticDemo;

/// The main application class.
///
/// @version    0.3.0
/// @since      0.1.0
public class Main implements Runnable {
    /// The default constructor.
    private Main() {
        super();
    }

    /// The run method.
    @Override
    public void run() {
        final List<Demo> demos = List.of(
                new MoveDemo(),
                new PatternDemo(),
                new GenericDemo(),
                new DefaultDemo(),
                new StaticDemo()
        );

        demos.forEach(Demo::demo);
    }

    /// The main application entry point.
    ///
    /// @param  args    java.lang.String[]
    public static void main(String[] args) {
        new Main().run();
    }
}
