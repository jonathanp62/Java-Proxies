package net.jmp.java.proxies.pattern;

/*
 * (#)ExpensiveImpl.java    0.2.0   05/10/2025
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

import static net.jmp.util.logging.LoggerUtils.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/// The expensive implementation class.
///
/// @version    0.2.0
/// @since      0.2.0
public class ExpensiveImpl implements Expensive {
    /// The logger.
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    /// The default constructor.
    public ExpensiveImpl() {
        super();

        this.initialize();
    }

    /// The initialize method.
    private void initialize() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        this.logger.info("Initializing the expensive implementation");

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }

    /// The process method.
    @Override
    public void process() {
        if (this.logger.isTraceEnabled()) {
            this.logger.trace(entry());
        }

        this.logger.info("Processing the expensive object");

        if (this.logger.isTraceEnabled()) {
            this.logger.trace(exit());
        }
    }
}
