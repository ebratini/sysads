/*
 * The MIT License
 *
 * Copyright 2012 Edwin Bratini <edwin.bratini@gmail.com>.
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
package com.ijr.model.ejb;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Edwin Bratini
 */
@Singleton
@LocalBean
public class SecurityServiceEJB {

    private static final String CHARSET = "UTF-8";

    public enum EncryptionMethod {

        SHA, SHA_512, SHA1, MD2, SHA_IMPLEMENTEDIN, SHA_256, MD5_IMPLEMENTEDIN, SHA_1, MD5, SHA_384;
        private String encryptionMethod;

        EncryptionMethod() {
            switch (ordinal()) {
                case 0:
                    encryptionMethod = super.toString();
                    break;
                case 1:
                    encryptionMethod = "SHA-512";
                    break;
                case 2:
                    encryptionMethod = super.toString();
                    break;
                case 3:
                    encryptionMethod = super.toString();
                    break;
                case 4:
                    encryptionMethod = "SHA ImplementedIn";
                    break;
                case 5:
                    encryptionMethod = "SHA-256";
                    break;
                case 6:
                    encryptionMethod = "MD5 ImplementedIn";
                    break;
                case 7:
                    encryptionMethod = "SHA-1";
                    break;
                case 8:
                    encryptionMethod = super.toString();
                    break;
                case 9:
                    encryptionMethod = "SHA-384";
                    break;
                default:
                    encryptionMethod = super.toString();
                    break;

            }
        }

        @Override
        public String toString() {
            return encryptionMethod;
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public synchronized String encrypt(String plaintext, EncryptionMethod encMethod) {
        try {
            MessageDigest md = MessageDigest.getInstance(encMethod.toString());
            md.update(plaintext.getBytes(CHARSET));

            byte raw[] = md.digest();
            String hash = (new BASE64Encoder()).encode(raw);
            return hash;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(SecurityServiceEJB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SecurityServiceEJB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public synchronized String encrypt(String plaintext) {
        return encrypt(plaintext, SecurityServiceEJB.EncryptionMethod.SHA);
    }
}
