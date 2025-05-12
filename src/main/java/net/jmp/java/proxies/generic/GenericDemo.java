package net.jmp.java.proxies.generic;

/*
 * (#)GenericDemo.java  0.2.0   05/10/2025
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

import java.util.List;

import net.jmp.java.proxies.Demo;

import static net.jmp.util.logging.LoggerUtils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// The generic demonstration class.
///
/// @version    0.2.0
/// @since      0.2.0
public class GenericDemo implements Demo {
    /// The logger.
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /// The default constructor.
    public GenericDemo() {
        super();
    }

    /// The demo method.
    @Override
    public void demo() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        final Book persuader = new Book("The Persuader", "Lee Child", 496);
        final Book theLastManager = new Book("The Last Manager", "John W. Miller", 368);

        final AmazonBox<Book> amazonBox = new AmazonBox<>();

        amazonBox.setColor("brown");

        final Box<Book> box = BoxProxy.newInstance(amazonBox);
        final int itemsPacked = box.pack(List.of(persuader, theLastManager));

        box.close();
        box.tape(3);

        final String shippingNumber = box.ship("123 Main Street");
        final List<Book> books = box.open();

        this.logger.info("The {} box has {} items packed", amazonBox.getColor(), itemsPacked);
        this.logger.info("The shipping number was {}", shippingNumber);
        this.logger.info("The books are {}", books);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }
}
