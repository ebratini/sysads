/*
 * The MIT License
 *
 * Copyright 2012 Edwin Bratini.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.ijr.business.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;

/**
 *
 * @author Edwin Bratini
 */
public class PhoneConverter implements javax.faces.convert.Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        String convVal = null;
        if (value != null) {
            char[] chars = value.trim().toCharArray();
            convVal = "";
            for (int k = 0; k < chars.length; k++) {
                if (chars[k] >= '0' && chars[k] <= '9') {
                    convVal += chars[k];
                }
            }
        }

        return convVal;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String convVal = null;
        if (value != null) {
            String sVal = null;
            try {
                sVal = (String) value; // The val object should be a String!
            } catch (ClassCastException e) {
                throw new ConverterException("PhoneConverter: Conversion Error");
            }
            if (!sVal.isEmpty()) {
                StringBuilder sbConvVal = new StringBuilder(sVal);
                sbConvVal.insert(0, "(");
                sbConvVal.insert(4, ")");
                sbConvVal.insert(6, " ");
                sbConvVal.insert(10, "-");
                convVal = sbConvVal.toString();
            }
        }
        return convVal;
    }
}
