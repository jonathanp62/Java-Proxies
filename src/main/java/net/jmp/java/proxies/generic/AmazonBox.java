package net.jmp.java.proxies.generic;

/*
 * (#)AmazonBox.java    0.2.0   05/10/2025
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

import static net.jmp.util.logging.LoggerUtils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// The Amazon box class.
///
/// @param  <T> The type of item in the box.
/// @version    0.2.0
/// @since      0.2.0
public class AmazonBox<T> implements Box<T> {
    /// The logger.
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /// The color of the box.
    private String color;

    /// The items in the box.
    private List<T> items;

    /// The default constructor.
    public AmazonBox() {
        super();
    }

    /// The pack method.
    ///
    /// @param  items java.util.List<T>
    /// @return       int
    @Override
    public int pack(final List<T> items) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(items));
        }

        this.items = items;

        final int countItems = items.size();

        this.logger.info("The {} box is packed with {} items", this.color, countItems);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(countItems));
        }

        return countItems;
    }

    /// The close method.
    @Override
    public void close() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        this.logger.info("The {} box was closed", this.color);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }

    /// The tape method.
    ///
    /// @param  pieces int
    @Override
    public void tape(final int pieces) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(pieces));
        }

        this.logger.info("The box was taped with {} pieces", pieces);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }

    /// The ship method.
    ///
    /// @param  address java.lang.String
    /// @return         java.lang.String
    @Override
    public String ship(final String address) {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entryWith(address));
        }

        final String shippingNumber = this.color + "-123456789";

        this.logger.info("The box was shipped to {}", address);
        this.logger.info("The shipping number is {}", shippingNumber);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(shippingNumber));
        }

        return shippingNumber;
    }

    /// The open method.
    ///
    /// @return java.util.List<T>
    @Override
    public List<T> open() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        this.logger.info("The {} box was opened", this.color);

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exitWith(this.items));
        }

        return this.items;
    }

    /// Get the color.
    ///
    /// @return java.lang.String
    public String getColor() {
        return this.color;
    }

    /// Set the color.
    ///
    /// @param  color java.lang.String
    public void setColor(final String color) {
        this.color = color;
    }
}
