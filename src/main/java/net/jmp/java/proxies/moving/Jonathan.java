package net.jmp.java.proxies.moving;

/*
 * (#)Jonathan.java 0.1.0   05/09/2025
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

import java.lang.reflect.Method;

import static net.jmp.util.logging.LoggerUtils.entry;
import static net.jmp.util.logging.LoggerUtils.exit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// The Jonathan class.
///
/// @version    0.1.0
/// @since      0.1.0
public class Jonathan implements Walker {
    /// The logger.
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /// The default constructor.
    public Jonathan() {
        super();
    }

    /// The walk home method.
    @Destination("8528 Harris Avenue")
    @Override
    public void walkHome() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        try {
            final Method method = this.getClass().getMethod("walkHome");
            final Destination destination = method.getAnnotation(Destination.class);

            this.logger.info("Jonathan is walking home to {}", destination.value());
        } catch (NoSuchMethodException e) {
            this.logger.error("Unable to find method: walkHome", e);
        }

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }

    /// The walk to work method.
    @Destination("3599 East Northern Parkway")
    @Override
    public void walkToWork() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        try {
            final Method method = this.getClass().getMethod("walkToWork");
            final Destination destination = method.getAnnotation(Destination.class);

            this.logger.info("Jonathan is walking to work at {}", destination.value());
        } catch (NoSuchMethodException e) {
            this.logger.error("Unable to find method: walkToWork", e);
        }

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }

    /// The move method.
    @Override
    public void move() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        this.logger.info("I hate having to move");

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }
}
