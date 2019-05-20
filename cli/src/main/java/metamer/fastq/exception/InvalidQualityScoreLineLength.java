/*
 * MIT License
 *
 * Copyright (c) 2019-present Denis Verkhoturov, Aleksandra Klimina,
 * Sophia Shalgueva, Irina Shapovalova, Anna Brusnitsyna
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

package metamer.fastq.exception;

import java.util.Objects;

public class InvalidQualityScoreLineLength extends Exception {
    private final int qualityScoreLineLength;

    public InvalidQualityScoreLineLength(final int qualityScoreLineLength) {
        super("Provided fastQ quality score line length is invalid, " +
                "a correct quality score line length is expected" +
                qualityScoreLineLength);
        this.qualityScoreLineLength = qualityScoreLineLength;
    }

    public int qualityScoreLineLength() {
        return this.qualityScoreLineLength;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        InvalidQualityScoreLineLength that = (InvalidQualityScoreLineLength) o;
        return qualityScoreLineLength == that.qualityScoreLineLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(qualityScoreLineLength);
    }
}
