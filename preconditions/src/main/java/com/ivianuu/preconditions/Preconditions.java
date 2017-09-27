/*
 * Copyright 2017 Manuel Wrage
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ivianuu.preconditions;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.Collection;
import java.util.Locale;

/**
 * Preconditions
 */
public final class Preconditions {

    private Preconditions() {
        throw new AssertionError("No instances");
    }

    /**
     * Ensures that an expression checking an argument is true.
     *
     * @param expression the expression to check
     * @throws IllegalArgumentException if {@code expression} is false
     */
    public static void checkArgument(boolean expression) {
        checkArgument(expression, null);
    }

    /**
     * Ensures that an expression checking an argument is true.
     *
     * @param expression the expression to check
     * @param errorMessage the exception message to use if the check fails
     * @throws IllegalArgumentException if {@code expression} is false
     */
    public static void checkArgument(boolean expression, @Nullable String errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * Ensures that the passed object is not null
     * @param object the nullable object
     * @throws NullPointerException if {@code object} is null
     */
    public static void checkNotNull(@Nullable Object object) {
        checkNotNull(object, null);
    }

    /**
     * Ensures that the passed object is not null
     * @param object the nullable object
     * @param errorMessage the exception message to use if the check fails
     * @throws NullPointerException if {@code object} was null
     */
    public static void checkNotNull(@Nullable Object object,
                                    @Nullable String errorMessage) {
        if (object == null) {
            throw new NullPointerException(errorMessage);
        }
    }

    /**
     * Ensures that that the argument numeric value is non-negative.
     *
     * @param value a numeric int value
     * @throws IllegalArgumentException if {@code value} was negative
     */
    public static void checkNonnegative(int value) {
        checkNonnegative(value, null);
    }

    /**
     * Ensures that that the argument numeric value is non-negative.
     *
     * @param value a numeric int value
     * @param errorMessage the exception message to use if the check fails
     * @throws IllegalArgumentException if {@code value} was negative
     */
    public static void checkNonnegative(int value,
                                        @Nullable String errorMessage) {
        if (value < 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * Ensures that that the argument numeric value is positive.
     *
     * @param value a numeric int value
     * @throws IllegalArgumentException if {@code value} was not positive
     */
    public static void checkPositive(int value) {
        checkPositive(value, null);
    }

    /**
     * Ensures that that the argument numeric value is positive.
     *
     * @param value a numeric int value
     * @param errorMessage the exception message to use if the check fails
     * @throws IllegalArgumentException if {@code value} was not positive
     */
    public static void checkPositive(int value,
                                    @Nullable String errorMessage) {
        if (value <= 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    /**
     * Ensures that the argument floating point value is within the inclusive range.
     *
     * @param value a floating point value
     * @param lower the lower endpoint of the inclusive range
     * @param upper the upper endpoint of the inclusive range
     * @param valueName the name of the argument to use if the check fails
     *
     * @throws IllegalArgumentException if {@code value} was not within the range
     */
    public static void checkArgumentInRange(float value, float lower, float upper,
                                            @NonNull String valueName) {
        if (value < lower) {
            throw new IllegalArgumentException(
                    String.format(Locale.US,
                            "%s is out of range of [%f, %f] (too low)", valueName, lower, upper));
        } else if (value > upper) {
            throw new IllegalArgumentException(
                    String.format(Locale.US,
                            "%s is out of range of [%f, %f] (too high)", valueName, lower, upper));
        }
    }

    /**
     * Ensures that the argument int value is within the inclusive range.
     *
     * @param value a int value
     * @param lower the lower endpoint of the inclusive range
     * @param upper the upper endpoint of the inclusive range
     * @param valueName the name of the argument to use if the check fails
     *
     * @throws IllegalArgumentException if {@code value} was not within the range
     */
    public static void checkArgumentInRange(int value, int lower, int upper,
                                            @NonNull String valueName) {
        if (value < lower) {
            throw new IllegalArgumentException(
                    String.format(Locale.US,
                            "%s is out of range of [%d, %d] (too low)", valueName, lower, upper));
        } else if (value > upper) {
            throw new IllegalArgumentException(
                    String.format(Locale.US,
                            "%s is out of range of [%d, %d] (too high)", valueName, lower, upper));
        }
    }

    /**
     * Ensures that the argument int value is within the inclusive range.
     *
     * @param value a long value
     * @param lower the lower endpoint of the inclusive range
     * @param upper the upper endpoint of the inclusive range
     * @param valueName the name of the argument to use if the check fails
     *
     * @throws IllegalArgumentException if {@code value} was not within the range
     */
    public static void checkArgumentInRange(long value, long lower, long upper,
                                            @NonNull String valueName) {
        if (value < lower) {
            throw new IllegalArgumentException(
                    String.format(Locale.US,
                            "%s is out of range of [%d, %d] (too low)", valueName, lower, upper));
        } else if (value > upper) {
            throw new IllegalArgumentException(
                    String.format(Locale.US,
                            "%s is out of range of [%d, %d] (too high)", valueName, lower, upper));
        }
    }

    /**
     * Ensures that the argument int value is within the inclusive range.
     *
     * @param value a double value
     * @param lower the lower endpoint of the inclusive range
     * @param upper the upper endpoint of the inclusive range
     * @param valueName the name of the argument to use if the check fails
     *
     * @throws IllegalArgumentException if {@code value} was not within the range
     */
    public static void checkArgumentInRange(double value, double lower, double upper,
                                            @NonNull String valueName) {
        if (value < lower) {
            throw new IllegalArgumentException(
                    String.format(Locale.US,
                            "%s is out of range of [%s, %s] (too low)", valueName, lower, upper));
        } else if (value > upper) {
            throw new IllegalArgumentException(
                    String.format(Locale.US,
                            "%s is out of range of [%s, %s] (too high)", valueName, lower, upper));
        }
    }

    /**
     * Ensures that an string reference passed as a parameter to the calling
     * method is not empty.
     *
     * @param string an string reference
     * @throws IllegalArgumentException if {@code string} is empty
     */
    public static void checkStringNotEmpty(@Nullable String string) {
        checkStringNotEmpty(string, null);
    }

     /**
      * Ensures that an string reference passed as a parameter to the calling
      * method is not empty.
      *
      * @param string an string reference
      * @param errorMessage the exception message to use if the check fails
      * @throws IllegalArgumentException if {@code string} is empty
      */
     public static void checkStringNotEmpty(@Nullable String string, @Nullable String errorMessage) {
         if (TextUtils.isEmpty(string)) {
             throw new IllegalArgumentException(errorMessage);
         }
     }

    /**
     * Ensures that a collection is not null or empty.
     *
     * @param collection the collection to check
     * @param errorMessage the exception message to use if the check fails
     * @throws IllegalArgumentException if {@code collection} is null or empty
     */
    public static void checkCollectionNotEmpty(@Nullable Collection<?> collection,
                                               @Nullable String errorMessage) {
        checkNotNull(collection, errorMessage);
        checkArgument(!collection.isEmpty(), errorMessage);
    }

    /**
     * Ensures that the {@code collection} is not null and none of its elements are null.
     *
     * @param collection a collection
     * @param valueName the name of the argument to use if the check fails
     *
     * @throws NullPointerException if the {@code value} or any of its elements were null
     */
    public static void checkCollectionElementsNotNull(Collection<?> collection,
                                                      @NonNull String valueName) {
        checkNotNull(collection);

        long i = 0;
        for (Object element : collection) {
            if (element == null) {
                throw new NullPointerException(
                        String.format(Locale.US, "%s[%d] must not be null", valueName, i));
            }
            ++i;
        }
    }


    /**
     * Ensures that the array and all of its elements are not null.
     *
     * @param value an array of objects
     * @param valueName the name of the argument to use if the check fails
     *
     * @throws NullPointerException if the {@code value} or any of its elements were null
     */
    public static void checkArrayElementsNotNull(@Nullable Object[] value,
                                                 @NonNull String valueName) {
        if (value == null) {
            throw new NullPointerException(valueName + " must not be null");
        }

        for (int i = 0; i < value.length; ++i) {
            if (value[i] == null) {
                throw new NullPointerException(
                        String.format(Locale.US, "%s[%d] must not be null", valueName, i));
            }
        }
    }

    /**
     * Ensures that the argument floating point value is a finite number.
     *
     * @param value a floating point value
     * @param valueName the name of the argument to use if the check fails
     *
     * @throws IllegalArgumentException if {@code value} was not finite
     */
    public static void checkArgumentFinite(float value,
                                           @NonNull String valueName) {
        if (Float.isNaN(value)) {
            throw new IllegalArgumentException(valueName + " must not be NaN");
        } else if (Float.isInfinite(value)) {
            throw new IllegalArgumentException(valueName + " must not be infinite");
        }
    }
}
