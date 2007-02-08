/*
 * Copyright (C) 2005-2006 Alfresco, Inc.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.alfresco.filesys.server.auth.spnego;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.DERApplicationSpecific;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERTaggedObject;

/**
 * SPNEGO Class
 * 
 * <p>Contains SPNEGO constants
 * 
 * @author gkspencer
 */
public class SPNEGO
{
    // Message types
    
    public static final int NegTokenInit    = 0;
    public static final int NegTokenTarg    = 1;
    
    // NegTokenInit context flags
    
    public static final int ContextDelete   = 0;
    public static final int ContextMutual   = 1;
    public static final int ContextReplay   = 2;
    public static final int ContextSequence = 3;
    public static final int ContextAnon     = 4;
    public static final int ContextConf     = 5;
    public static final int ContextInteg    = 6;
    
    // NegTokenTarg result codes
    
    public static final int AcceptCompleted     = 0;
    public static final int AcceptIncomplete    = 1;
    public static final int Reject              = 2;
    
    /**
     * Return a result code as a string
     * 
     * @param res int
     * @return String
     */
    public static String asResultString(int res)
    {
        String resStr = null;
        
        switch ( res)
        {
        case AcceptCompleted:
            resStr = "AcceptCompleted";
            break;
        case AcceptIncomplete:
            resStr = "AcceptIncomplete";
            break;
        case Reject:
            resStr = "Reject";
            break;
        default:
            resStr = "" + res;
            break;
        }
        
        return resStr;
    }
    
    /**
     * Determine the SPNEGO token type
     * 
     * @param buf byte[]
     * @param off int
     * @param len int
     * @return int
     * @exception IOException
     */
    public static int checkTokenType( byte[] buf, int off, int len)
        throws IOException
    {
        // Create a stream around the security blob
        
        ByteArrayInputStream bytStream = new ByteArrayInputStream( buf, off, len);
        ASN1InputStream asnStream = new ASN1InputStream( bytStream);
        
        // Read the top level object from the security blob
        
        DERObject derObj = asnStream.readObject();
        int tokType = -1;
        
        if ( derObj instanceof DERApplicationSpecific)
        {
            // Looks like a NegTokenInit token
            
            tokType = NegTokenInit;
        }
        else if ( derObj instanceof DERTaggedObject)
        {
            // Check the tag number
            
            DERTaggedObject derTag = (DERTaggedObject) derObj;
            if ( derTag.getTagNo() == 1)
                tokType = NegTokenTarg;
        }
        
        //  Close the streams
        
        asnStream.close();
        bytStream.close();
        
        //  Return the token type
        
        return tokType;
    }
}
